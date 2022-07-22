package be.digitalcity.tu;

public class Iban {
    String iban;

    public Iban(String iban) {
        this.iban = iban.replaceAll("[-+.\\s/*^:,]","");
    }

    public Boolean isValide() throws IbanExeption {
        if(!iban.startsWith("BE")) throw new IbanExeption("ceci n'est pas un Iban Belge");
        if(iban.length()!=16) throw new IbanExeption("Le Iban doit etre composer des 16 caractere");
        if(!isLong(iban.substring(4,16))) throw new IbanExeption("Le Iban doit etre composer de deux lettre majuscule suivis de 14 chiffre");

        if(Long.parseLong(iban.substring(4,14)) % 97 == Long.parseLong(iban.substring(14,16)) ) return true;
        if((Long.parseLong(iban.substring(4,14)) % 97 == 0) && ( Long.parseLong(iban.substring(14,16)) == 97)) return true;

        return false;
    }

    public boolean isLong(String str){
        try{
           Long l = Long.parseLong(str);
           return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}


//throw new IbanExeption("modulo 97 = 2 dernier chiffre")
//throw new IbanExeption("modulo 97 = 0 et 2 dernier chiffre = 97");