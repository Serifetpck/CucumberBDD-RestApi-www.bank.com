package utils;

import baseurl.BankUrl;

public class ReusableMethods {

    public static String gmiBankUrlSetup(String pathPram){
        String url= BankUrl.gmiBankurl+pathPram;

        return url;
    }
}
