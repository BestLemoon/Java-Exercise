import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import sun.text.resources.iw.FormatData_iw_IL;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class exe1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("1.txt");
        Scanner in = new Scanner(file);
        ArrayList<String> strings = new ArrayList<String>();
        while (in.hasNext()) {
            String str = in.nextLine();
            str = str.replace("John", "");
            strings.add(str);
        }
        in.close();
        PrintWriter out = new PrintWriter(file);
        for (int i = 0; i < strings.size(); i++) {
            out.write(strings.get(i) + "\n");
        }
        out.flush();
        out.close();
    }
}

class exe2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("2.txt");
        Scanner in = new Scanner(file);
        int count = 0, sum = 0;
        while (in.hasNext()) {
            sum += in.nextInt();
            count++;
        }
        System.out.println("sum: " + sum + ",ave: " + sum * 1.0 / count);
    }
}

class exe3 {
    public static void main(String[] args) throws IOException {
        File file = new File("3.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            out.write(random.nextInt(100) + " ");
        }
        out.flush();
        out.close();
    }
}

class exe4 {
    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 1; i <= 34; i++) {
            File file = new File("srcRootDirectory\\" + "chapter" + i + "\\" + "chapter" + i + ".java");
            PrintWriter out = new PrintWriter(file);
            Scanner in = new Scanner(file);
            ArrayList<String> strings = new ArrayList<String>();
            while (in.hasNext()) {
                strings.add(in.nextLine());
            }
            in.close();
            out.write("pachage chapter" + i);
            for (int j = 0; j < strings.size(); j++) {
                out.write(strings.get(j) + "\n");
            }
            out.flush();
            out.close();
        }
    }
}

class exe5 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("5.txt");
        Scanner in = new Scanner(file);
        String[] strings = new String[2];
        while (in.hasNext()) {
            String tmp1, tmp2;
            tmp1 = in.next();
            tmp2 = in.next();
            if (tmp1.compareTo(tmp2) <= 0)
                continue;
            else {
                strings[0] = tmp1;
                strings[1] = tmp2;
                break;
            }
        }
        if (strings.length != 0) {
            System.out.println(strings[0] + " " + strings[1]);
        }
    }
}

class exe6 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
        Scanner in = new Scanner(url.openStream());
        int sum = 0, count = 0;
        while (in.hasNext()) {
            sum += in.nextInt();
            count++;
        }
        System.out.println(sum + " " + sum * 1.0 / count);
    }
}

class exe7 {
    public static void main(String[] args) throws IOException {
        File file = new File("7.txt");
        if (!file.exists())
            file.createNewFile();
        PrintWriter out = new PrintWriter(file);
        String[] strings = {"assistant", "associate", "full"};
        int[] salaries = {50000, 60000, 75000};
        for (int i = 0; i <= 1000; i++) {
            Random random = new Random();
            int level = random.nextInt(3);
            double salary = 0;
            switch (level) {
                case 1:
                    salary = salaries[level] + random.nextDouble() * 30000;
                case 2:
                    salary = salaries[level] + random.nextDouble() * 50000;
                case 3:
                    salary = salaries[level] + random.nextDouble() * 55000;
            }
            out.write("FirstName" + i + " LastName" + i + strings[level] + " " + salary + "\n");
        }
        out.flush();
        out.close();
    }
}

class exe8 {
    public static void main(String[] args) {
        String path = "";
        ArrayList<String> names = getFile(path);
        if (args[0] == "*") {
            for (int i = 0; i < names.size(); i++)
                System.out.println(names.get(i));
            System.exit(0);
        }
        Pattern pattern = Pattern.compile("_[0-9]*");
        for (int i = 0; i < names.size(); i++) {
            Matcher matcher = pattern.matcher(names.get(i));
            String tmp = matcher.group();
            if (tmp.length() == 2) {
                File file = new File(path + "\\" + names.get(i));
                file.renameTo(new File(file.getName().replace(Character.toString(tmp.charAt(1)), "0" + tmp.charAt(1))));
            }
        }
    }

    public static ArrayList<String> getFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        ArrayList<String> filenames = new ArrayList<String>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].exists()) {
                filenames.add(files[i].getName());
            }
        }
        return filenames;
    }
}

class exe9 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] counts = new int[58];
        File file = new File("9.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String string = in.nextLine();
            for (int i = 0; i < string.length(); i++) {
                counts[string.charAt(i) - 'A']++;
            }
        }
        for (int i = 0; i <= 'Z' - 'A' + 1; i++) {
            if (counts[i] != 0)
                System.out.println("Number of " + (char) (i + 'A') + "'s: " + counts[i]);
        }
        for (int i = 0; i <= 'z' - 'a' + 1; i++) {
            if (counts[i] != 0)
                System.out.println("Number of " + (char) (i + 'a') + "'s: " + counts[i]);
        }
        in.close();
    }
}

class exe10 {
    public static void main(String[] args) throws IOException {
        File file = new File("7.txt");
        if (!file.exists())
            file.createNewFile();
        PrintWriter out = new PrintWriter(file);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            out.write(random.nextInt(100) + " ");
        }
        out.flush();
        out.close();
    }
}

class exe11 {
    public static void main(String[] args) throws IOException {
        File file = new File("7.dat");
        if (!file.exists())
            file.createNewFile();
        PrintWriter out = new PrintWriter(file);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            out.write(random.nextInt(100) + " ");
        }
        out.flush();
        out.close();
    }
}

class exe12 {
    public static void main(String[] args) throws IOException {
        File file = new File("12.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        int[] ints = {1, 2, 3, 4, 5};
        Date date = new Date();
        double num = 5.5;
        outputStream.writeObject(ints);
        outputStream.writeObject(date);
        outputStream.writeDouble(num);
        outputStream.flush();
        outputStream.close();
    }
}

class exe13 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("Exercise19_08.dat", "rw");
        int count = 0;
        if (raf.length() > 0)
            count = raf.readInt();
        raf.seek(0);
        raf.writeInt(++count);
        System.out.println("Current count is " + count);
        raf.close();
    }
}

class exe14 {
    public static void main(String[] args) throws IOException {
        byte[] data = new byte[20971520];//20MB
        File file = new File("1.avi");
        FileInputStream in = new FileInputStream(file);
        int len, i = 0;
        while ((len = in.read(data, 0, data.length)) != -1) {
            File fileout = new File("SourceFile" + Integer.toString(i++));
            fileout.createNewFile();
            FileOutputStream out = new FileOutputStream(fileout);
            out.write(data);
            out.flush();
            out.close();
        }
        in.close();
    }
}

class exe15 {
    public static void main(String[] args) throws IOException {
        File fileout = new File("TargetFile");
        fileout.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(fileout);
        for (int i = 1; i < 100; i++) {
            File filein = new File("SouceFile" + Integer.toString(i));
            FileInputStream inputStream = new FileInputStream(filein);
            int data;
            while ((data = inputStream.read()) != -1)
                outputStream.write(data);
            inputStream.close();
        }
        outputStream.flush();
        outputStream.close();
    }
}

class exe16 {
    public static void main(String[] args) throws IOException {
        File filein = new File("17.txt");
        File fileout = new File("17out.txt");
        fileout.createNewFile();
        FileInputStream inputStream = new FileInputStream(filein);
        FileOutputStream outputStream = new FileOutputStream(fileout);
        int data;
        while ((data = inputStream.read()) != -1)
            outputStream.write(data + 5);
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}

class exe17 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] counts = new int[256];
        File file = new File("17.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            counts[in.next().charAt(0)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (counts[i] != 0)
                System.out.println(counts[i]);
        }
    }
}

class exe18 {
    public static void main(String[] args) throws IOException {
        File file = new File("18.dat");
        BitOutputStream bitOutputStream = new BitOutputStream(file);
        bitOutputStream.writeBit("010000100100001001101");
        bitOutputStream.close();
    }
}

class BitOutputStream {
    private FileOutputStream output;
    private int value = 0;
    private int mask = 1;
    private int count = 0;

    public BitOutputStream(File file) throws IOException {
        output = new FileOutputStream(file);
    }

    public void writeBit(char bit) throws IOException {
        count++;
        value = value << 1;
        if (bit == '1') {
            value = value | mask;
        }
        if (count == 8) {
            output.write(value);
            count = 0;
        }
    }

    public void writeBit(String bit) throws IOException {
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    public void close() throws IOException {
        if (count > 0) {
            value = value << (8 - count);
            output.write(value);
        }
        output.close();
    }
}

class exe19 {
    public static void main(String[] args) throws IOException {
        File file = new File("19.txt");
        FileInputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = inputStream.read()) != -1) {
            System.out.println(Integer.toHexString(data));
        }
    }
}















