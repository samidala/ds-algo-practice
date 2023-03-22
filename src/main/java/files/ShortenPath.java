package files;

import java.util.*;

public class ShortenPath {

    private static final Directory root = new Directory("/");


    public static void main(String[] args) {

        createDirs();
        shortenedPath(root,new StringBuilder());


    }

    private static void createDirs() {
        Directory ad = new Directory("ad");
        ad.files.add(new File("afile"));
        ad.files.add(new File("bfile"));
        ad.files.add(new File("cfile"));

        Directory bd = new Directory("bd");

        Directory bda = new Directory("bda");
        bda.files.add(new File("bdaFile1"));
        bda.files.add(new File("bdaFile2"));
        bda.files.add(new File("bdaFile3"));

        Directory bdb = new Directory("bdb");
        bdb.files.add(new File("bdbfile1"));
        bdb.files.add(new File("bdbfile2"));
        Directory bdba = new Directory("bdba");
        bdb.subDirs.add(bdba);

        bd.subDirs.add(bda);
        bd.subDirs.add(bdb);

        Directory cd = new Directory("cd");

        Directory cda = new Directory("cda");

        cda.files.add(new File("cda file1"));
        cda.files.add(new File("cda file2"));
        cda.subDirs.add(new Directory("cdaa"));

        Directory cdb = new Directory("cdb");
        cdb.files.add(new File("cdb file1"));
        cdb.files.add(new File("cdb file2"));

        cd.subDirs.add(cda);
        cd.subDirs.add(cdb);


        ad.subDirs.add(bd);
        ad.subDirs.add(cd);

        Directory aad = new Directory("aad");
        Directory bad = new Directory("bad");
        Directory cad = new Directory("cad");
        cad.files.add(new File("cadFile1.txt"));
        ad.subDirs.add(aad);
        ad.subDirs.add(bad);
        ad.subDirs.add(cad);

        root.getSubDirs().add(ad);
    }

    public static void shortenedPath(Directory root,StringBuilder sb){

        if(!root.getSubDirs().isEmpty()){
            for (Directory dir : root.subDirs) {
                StringBuilder temp = new StringBuilder(sb);
                shortenedPath(dir, temp.append("/").append(dir.name));
                if (dir.subDirs.isEmpty() && dir.files.isEmpty())
                    System.out.println("dir: "+ temp);
               // temp = new StringBuilder(sb);
            }


        }
        root.files.forEach(
                file -> System.out.println(sb + "/"+file.getName())
        );

    }



    static class Directory{
        private String name;
        private Set<Directory> subDirs = new HashSet<>();

        private Set<File> files = new HashSet<>();

        public Directory(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Directory setName(String name) {
            this.name = name;
            return this;
        }

        public Set<Directory> getSubDirs() {
            return subDirs;
        }

        public Directory setSubDirs(Set<Directory> subDirs) {
            this.subDirs = subDirs;
            return this;
        }

        public Set<File> getFiles() {
            return files;
        }

        public Directory setFiles(Set<File> files) {
            this.files = files;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Directory directory = (Directory) o;
            return name.equals(directory.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class File{
        private String name;

        public File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public File setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            File file = (File) o;
            return Objects.equals(name, file.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
