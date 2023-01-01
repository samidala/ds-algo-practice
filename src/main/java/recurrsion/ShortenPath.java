package recurrsion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ShortenPath {


    public static void main(String[] args) {
        String allFiles[] = {"/ad/b.txt","/bd/c.txt","/bd/d.txt","/cd/cdFile.txt","/cd/cdFile2.txt","/cd/xd/a.txt","/cd/xd/b.txt",
        "/dd/ed/fd/file1.txt","/dd/ed/fd/file2.txt"};

        String selectedFiles[] = {"/ad/b.txt","/bd/c.txt","/bd/d.txt","/cd/cdFile.txt","/cd/xd/a.txt","/cd/xd/b.txt",
                "/dd/ed/fd/file1.txt","/dd/ed/fd/file2.txt"};//,

        FileImpl fileImpl = new FileImpl();
        fileImpl.build(allFiles);
        fileImpl.markSelected(selectedFiles);
        System.out.println("printing all");
        //fileImpl.print();
        System.out.println("shortest path!!");
        fileImpl.printShortest();
    }


    static class Directory{
        private String name;

        protected Set<String> selectedFiles = new LinkedHashSet<>();

        private Boolean isAllSelected;
        private Set<String> files = new LinkedHashSet<>();
        private Set<Directory> subDir = new LinkedHashSet<>();


        Directory(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Directory directory = (Directory) o;
            return Objects.equals(name, directory.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class FileImpl{
        private Directory root = new Directory("/");
        static String separator = "/";

         void build(String[] allFiles){
            for(String cur : allFiles){
                String[] paths = cur.split(separator);
                Directory current = root;
                for(int i = 1 ; i < paths.length - 1; i++){
                    String name = paths[i];
                    Directory sub = current.subDir.stream().filter(e-> e.name.equals(name)).findFirst().orElse(null);
                    if(sub == null){
                        sub = new Directory(name);
                        current.subDir.add(sub);
                    }
                    current = sub;
                }
                //current.files.add((paths[paths.length - 1]));
                current.files.add(cur);
            }

        }

        void markSelected(String[] selectedFiles){
            for(String cur : selectedFiles){
                String[] paths = cur.split(separator);
                Directory current = root;
                for(int i = 1 ; i < paths.length - 1; i++){
                    String name = paths[i];
                    current = current.subDir.stream().filter(dir -> dir.name.equals(name)).findFirst().orElse(null);
                    if(current == null){
                        break;
                    }

                }
                if(current != null) {
                    //current.files.add(cur);
                    //if(current.files.contains(paths[paths.length - 1])){
                    if(current.files.contains(cur)){
                            current.selectedFiles.add(cur);
                        }
                    }
                    current.isAllSelected = current.files.size() == current.selectedFiles.size();
                    System.out.println(current.name + " isAllSelected "+current.isAllSelected);
            }


        }

        public void print(){

             root.subDir.forEach(this::print);
        }

        public void printShortest(){
            Collection<Directory> set = root.subDir;
            for(Directory dir : set){
                boolean isAllSubSelected = true;
                List<String> path = new ArrayList<>();
                for (Directory subDir : dir.subDir){


                    if(!printShortest(subDir,path,dir.files.size() == dir.selectedFiles.size()) && !path.isEmpty()){
                        isAllSubSelected = false;
                        //System.out.println("size 123 "+path.size());
                    }
                    if(dir.files.size() != dir.selectedFiles.size() && !path.isEmpty()){
                       // System.out.println("path.isEmpty() size "+path.size());
                    }
                }
                if(isAllSubSelected && dir.files.size() == dir.selectedFiles.size()){
                    System.out.println("directory name "+dir.name);
                }else{
                    path.forEach(System.out::println);
                }

            }

        }

        private boolean printShortest(Directory dir, List<String> path, boolean print){

             if(dir.subDir.size() == 0){
                 if(dir.files.size() == dir.selectedFiles.size()){
                    // path.add(dir.name);
                     return true;
                 }else{
                     path.addAll(dir.selectedFiles);
                     return false;
                 }
             }
             boolean isAllSubSelected = true;
             for(Directory sub : dir.subDir){
                 boolean isAllSelected = printShortest(sub,path, sub.selectedFiles.size() == sub.files.size());
                 if(!isAllSelected){
                     isAllSubSelected = false;
                 }

             }
             if(dir.selectedFiles.size() != 0 ) {
                 if (dir.files.size() == dir.selectedFiles.size()) {
                     path.add(dir.name);
                     return isAllSubSelected;
                 } else {
                     path.addAll(dir.selectedFiles);
                     return false;
                 }
             }else {
                 return false;
             }
       }




        private void print(Directory dir){
            System.out.println(dir.name +" "+ (dir.files.size()  == dir.selectedFiles.size()));
            dir.files.forEach(System.out::println);
            for(Directory sub : dir.subDir){
                print(sub);
            }
        }

    }



}
