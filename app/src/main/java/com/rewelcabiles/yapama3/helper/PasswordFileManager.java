package com.rewelcabiles.yapama3.helper;

import android.content.Context;

import com.rewelcabiles.yapama3.passwordList.Password;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordFileManager {

    public static List<Password> generate_password_list(Context context) {
        List<Password> passwordList = new ArrayList<>();
        File directory = context.getFilesDir();
        String[] files = context.fileList();
        for(String file_name:files){
            File file = new File(directory, file_name);

            int length = (int) file.length();

            byte[] bytes = new byte[length];

            FileInputStream in = null;
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            String contents = new String(bytes);
            Password pass = new Password(file_name, contents);
            passwordList.add(pass);
        }
        return passwordList;
    }

    public static void add_password(Password password, Context context) {
        File directory = context.getFilesDir();
        File file = new File(directory, password.getName());
        if (!file.exists()){
            FileOutputStream stream = null;
            try {
                stream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                stream.write("text-to-write".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else{
            System.out.println("PWD ALRDY EXIS");
        }
        String[] files = context.fileList();
        System.out.println(Arrays.toString(files));

    }
}
