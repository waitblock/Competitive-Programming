import java.util.*;
import java.io.*;

public final class CF_1722A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    final String[] validA = {"Timur","iTmur","mTiur","Tmiur","imTur","miTur","uiTmr","iuTmr","Tuimr","uTimr","iTumr","Tiumr","Tmuir","mTuir","uTmir","Tumir","muTir","umTir","umiTr","muiTr","iumTr","uimTr","miuTr","imuTr","rmuTi","mruTi","urmTi","rumTi","murTi","umrTi","Tmrui","mTrui","rTmui","Trmui","mrTui","rmTui","ruTmi","urTmi","Trumi","rTumi","uTrmi","Turmi","Tumri","uTmri","mTuri","Tmuri","umTri","muTri","iuTrm","uiTrm","Tiurm","iTurm","uTirm","Tuirm","ruiTm","uriTm","iruTm","riuTm","uirTm","iurTm","iTrum","Tirum","riTum","irTum","Trium","rTium","rTuim","Truim","urTim","ruTim","Turim","uTrim","mTriu","Tmriu","rmTiu","mrTiu","Trmiu","rTmiu","iTmru","Timru","miTru","imTru","Tmiru","mTiru","mriTu","rmiTu","imrTu","mirTu","rimTu","irmTu","irTmu","riTmu","Tirmu","iTrmu","rTimu","Trimu","urimT","ruimT","iurmT","uirmT","riumT","irumT","mruiT","rmuiT","umriT","muriT","rumiT","urmiT","uimrT","iumrT","muirT","umirT","imurT","miurT","miruT","imruT","rmiuT","mriuT","irmuT","rimuT"};
    HashSet<String> valid = new HashSet<>();
    for(String s : validA) valid.add(s);
    for(int testcase = 0; testcase < t; testcase++){
      in.nextInt();
      String s = in.next();
      System.out.println(valid.contains(s) ? "YES" : "NO");
    }
  }
}
