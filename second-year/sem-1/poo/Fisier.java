class ClientFisier{
    private String name;
    private String content;
    private int id;
    private static int id_count=1;
    private ClientFisier fisier_anterior=null;
    private int nr_concat =0;
    
    public ClientFisier(String n, String c){
        name=n;
        content=c;
        id=id_count++;
    }
    
    public void salveazaVersiune(){
        ClientFisier fis;
        fis=new ClientFisier(name + "bak", content);
        if(fisier_anterior==null){
            fisier_anterior=fis;
        }
        else {
            fis.fisier_anterior=fisier_anterior;
            fisier_anterior=fis;
        }
    }
    
    public void concateneaza(ClientFisier fis){
        salveazaVersiune();
        content=content + fis.content;
        nr_concat++;
    }
    
    public String toString(){
        String aux=id+" " + name + " "+ content+"\n";
        if(fisier_anterior==null) return aux;
        else return aux + fisier_anterior.toString();
    }
    
    public int numarConcatenari(){
        return nr_concat;
    }
    
}
    
    public class Fisier{
        public static void main(String args[]){
            ClientFisier f1,f2;
            f1=new ClientFisier("fisier1","continut1");
            f2=new ClientFisier("fisier2","continut2");
            f1.salveazaVersiune();
            f2.salveazaVersiune();
            f1.concateneaza(f2);
            System.out.println(f1);
        }
    }
    
    
    
    
    
    
    
    
