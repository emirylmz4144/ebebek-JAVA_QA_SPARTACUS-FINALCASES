package PatikaStore;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class NotebookManagement
{
    LinkedHashMap<Integer,Notebook> notebookList= new LinkedHashMap<>();
    AtomicInteger notebookID = new AtomicInteger();
    Scanner input = new Scanner(System.in);



    public void notebook()
    {
       boolean stateOfNotebook = true;

        while (stateOfNotebook)
        {
            System.out.println("Notebook Yönetim Paneli !");
            System.out.println("""
                              1-Ürün Ekleme işlemi
                              2-Ürün silme işlemi
                              3-Ürünleri Listeleme işlemi
                              0-Çıkış Yap""");
            int choose = input.nextInt();
            System.out.println("Seçiminiz: " + choose);


            while (choose < 0 || choose > 3)
            {
                System.out.println("Lütfen geçerli bir sayı giriniz.");
                choose = input.nextInt();
            }
            switch (choose){
                case 1:
                    addNotebook();
                    break;
                case 2:
                    if(deleteNotebook())
                    {
                        System.out.println("Silme işlemi başarılı");
                        break;
                    }
                    else
                    {
                        System.out.println("Eksik Yada Hatalı ID girdiğiniz için silme işlemi gerçekleşmedi");
                    }
                    break;
                case 3:
                    showNotebookList();
                    break;
                case 0:
                    stateOfNotebook = false;
                    break;
            }
        }

    }

    public void showNotebookList()
    {
        System.out.println("NotebookListesi ");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "| ID | Ürün Adı                   | Fiyat           | Marka      | Depolama Alanı    | Ekran Boyutu     | Kamera    | Pil Gücü     | Renk      |   RAM       |");
        for (Integer keyset: notebookList.keySet())
        {
            System.out.println(
              "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            notebookList.get(keyset).printInformationsOfNotebook();
        }
    }
    private void addNotebook()
    {
        int id=notebookID.incrementAndGet();
        System.out.println("ürün Adı: ");
        input.next();
        String productName = input.nextLine();
        System.out.println("Fiyatı: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Marka Adı: ");
        String brandName = input.nextLine();
        System.out.println("Depolama Alanı: ");
        int storage = input.nextInt();
        System.out.println("Ekran Boyutu: ");
        double screenSize = input.nextDouble();
        System.out.println("Kamera Çözünürlüğü: ");
        int camera = input.nextInt();
        System.out.println("Pil: ");
        int power = input.nextInt();
        System.out.println("Ram: ");
        int ram = input.nextInt();
        System.out.println("Renk: ");
        String color = input.next();
        System.out.println("Stok Miktarı: ");
        int Quantity = input.nextInt();
        notebookList.put(id,new Notebook(id,productName,price,brandName,storage,screenSize,camera,power,ram,color,Quantity));

    }
    private boolean deleteNotebook(){
        System.out.println("Silmek İstediğiniz ürünün ID'sini giriniz: ");
        int oldSize = notebookList.size();
        int id = input.nextInt();
        notebookList.remove(id);
        int newSize = notebookList.size();

        return newSize != oldSize;
    }


}
