public class ChargenClient
{
    public static int DEFAULT_PORT = 19;

    public static void main(String[] args){

        if(args.length == 0){
            System.out.println("Usage: java ChargenClient host [port]");
            return ;
        }

        for(int i = 0;i<args.length;i++){
            System.out.println(args[i]);
        }

        System.out.println(args.length);

    }
}
