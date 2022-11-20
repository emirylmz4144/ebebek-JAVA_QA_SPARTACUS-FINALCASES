package PatikaStore;

import java.util.*;
public class BaseManagementPanel
{
    PhoneManagement phoneManagement = new PhoneManagement();
    NotebookManagement notebookManagement = new NotebookManagement();
    Scanner input = new Scanner(System.in);
    private boolean isRun = true;

    public void run()
    {
        int choose;
        while (isRun)
        {
            System.out.println("PatikaStore Yönetim Paneli !");
            System.out.println("""
                              1-Notebook İşlemleri
                              2-Cep Telefonu İşlemleri
                              3-Marka Listele
                              0-Çıkış Yap""");


            choose = input.nextInt();
            System.out.println("Tercihiniz : " + choose);

            while (choose < 0 || choose > 3)
            {
                System.out.println("Lütfen geçerli bir seçim giriniz.");
                choose = input.nextInt();
            }
            switch (choose)
            {
                case 1 -> notebookManagement.notebook();
                case 2 -> phoneManagement.Phone();
                case 3 -> Brand.printDefaultBrand();
                case 0 -> isRun = false;
            }
        }
    }

}

