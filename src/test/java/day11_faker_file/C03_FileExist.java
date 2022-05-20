package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\90531\IdeaProjects\Batch59JUnit
        //bana ıcınd4 oldugum projenın dosya yolunu verir

        System.out.println(System.getProperty("user.home"));
        //C:\Users\90531 bilgisayarımın bana ozel kısmını verir
        //C:\Users\90531\Dowloads
        //C:\Users\90531\Desktop
        //C:\Users\90531\IdeaProjects\Batch59JUnit\src

        //homePath+"/Downloads"

        //masaustumuzdeki text dosyasının varlıgını test edin
        //"C:\Users\90531\OneDrive\Masaüstü\text.txt"
        String dosyaYolu=System.getProperty("user.home")+"\\Onedrive\\Masaüstü\\text.txt";
        System.out.println(dosyaYolu);
        /*Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
javada dosyaya erisim icin dosya yoluna yani path e ihtiyac vardir
Her bilgisayarin kullanici adi farkli olacagindan masa ustu
dosya yoluda birbirinden farkli olacaktir
testlerimizin tum bilgisayarlarda calismasi icin
dosya yolunu DINAMIK yapmak zorundayiz
*/

//bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim=System.getProperty("user.home");

//herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";

        String masaUstuDosyaYolu=farkliKisim+ortakKisim;
        System.out.println("masaUstuDosyaYolu = " + masaUstuDosyaYolu);
        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));
    }
}

