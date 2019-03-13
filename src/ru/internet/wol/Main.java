package ru.internet.wol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        param param = null;
        WOL wol = new WOL();
        //todo make norm switch
        for(int i = 0;i<args.length;i++){
            try {
                switch (args[i]){
                    case "-m":
                        param = ru.internet.wol.param.mac;
                        wol.setMac(args[i+1]);
                        break;
                    case "-i":
                        param = ru.internet.wol.param.ip;
                        wol.setIp(args[i+1]);
                        break;
                    case "-p":
                        param = ru.internet.wol.param.port;
                        wol.setPort(args[i+1]);
                        break;
                    case "--help":
                        help();
                        System.exit(0);
                        break;
                }
            }
            catch (Exception ex){
                Exceptions.throwException(Exceptions.wrong_param + param);
            }
        }
        wol.wakeUp();
    }
    //todo Make HELP file/
    private static void help(){
        try {
            //URL url = Main.class.getResource("Help");
            File file = new File(Main.class.getResource("Help").getPath());
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
//-m E0:3F:49:15:D5:AF -i 85.113.58.194