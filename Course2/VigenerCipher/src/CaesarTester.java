import edu.duke.FileResource;
public class CaesarTester {

    public void testCaesar(){
        FileResource fileResource = new FileResource("TestData/Week4/titus-small.txt");
        String data = fileResource.asString();
        System.out.println(data);

        CaesarCipher caesarCipher = new CaesarCipher(25);
        String ciphered = caesarCipher.encrypt(data);
        System.out.println(ciphered);

        String deciphered = caesarCipher.decrypt(ciphered);
        System.out.println(deciphered);
    }

    public static void main(String[] args) {
        CaesarTester caesarTester = new CaesarTester();
        caesarTester.testCaesar();
    }
}
