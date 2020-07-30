package helper;

import java.io.File;

public class FileManager {

  private String filePath = "";
  private String csvName = "pics";
  private String csvExtension = ".csv";
  private boolean debug = false;

  public boolean checkDevicePicCSV() {
    String csvFolder = getCSVPath();
    try { 
      File[] listFiles = new File(csvFolder).listFiles();
      for (int i = 0; i < listFiles.length; i++) {
        if (listFiles[i].isFile()) {
          String fileName = listFiles[i].getName();
          if (fileName.contains(csvName)
              && fileName.endsWith(csvExtension)) {
            System.out.println("pics.csv file found in " + csvFolder);
            setFilePath(fileName);
            return true;
          }
        }
      }
      String errorMessage = "pics.csv not found.\n";
      System.err.println(errorMessage);
    } catch(Exception e) {
      System.out.println("Error in reading " + csvName + csvExtension + " in " + csvFolder);
    }
    return false;
  }

  private void setFilePath(String fileName) {
    String absolutePath = getCSVPath();
    this.filePath = absolutePath + "/" + fileName;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public String getAbsolutePath() {
    String absolutePath = "";
    String systemPath = System.getProperty("user.dir");
    System.out.println("system_path: " + systemPath);
    String[] path_arr = systemPath.split("/");
    for (int count = 0; count < path_arr.length; count++) {
      if (pathArr[count].equals("bacnetTests")) {
        break;
      }
      absolutePath += pathArr[count] + "/";
    }
    return absolutePath;
  }

  public String getCSVPath() {
    if (debug) {
      return "src/main/resources";
    }
    return "/config/type";
  }
}
