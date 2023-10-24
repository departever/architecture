import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        System.out.println("请选择1.主程序-子程序 2.面向对象 3.事件系统 4.管道-过滤对应的体系结构：");
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();

        switch (i) {
            case 1:
                System.out.println("执行主程序-子程序代码块");
                demo kwic1 = new demo();
                kwic1.input("D:\\test\\1.txt");
                kwic1.shift();
                kwic1.alphabetizer();
                kwic1.output("D:\\test\\2.txt");
                try {
                    String fileName = "D:\\test\\2.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("执行面向对象代码块");
                oopInput oopInput = new oopInput();
                oopInput.input("D:\\test\\1.txt");
                oopShift oopShift = new oopShift(oopInput.getLineTxt());
                oopShift.shift();
                oopAlphabetizer oopAlphabetizer = new oopAlphabetizer(oopShift.getKwicList());
                oopAlphabetizer.sort();
                oopOutput oopOutput = new oopOutput(oopAlphabetizer.getKwicList());
                oopOutput.output("D:\\test\\2.txt");
                try {
                    String fileName = "D:\\test\\2.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("执行事件系统代码块");
                //创建主题
                KWICObsSubject kwicObsSubject = new KWICObsSubject();
                //创建观察者
                ObsInput input = new ObsInput("D:\\test\\1.txt");
                ObsShift shift = new ObsShift(input.getLineTxt());
                ObsAlphabetizer alphabetizer = new ObsAlphabetizer(shift.getKwicList());
                ObsOutput output = new ObsOutput(alphabetizer.getKwicList(), "D:\\test\\2.txt");

                // 将观察者加入主题
                kwicObsSubject.addObserver(input);
                kwicObsSubject.addObserver(shift);
                kwicObsSubject.addObserver(alphabetizer);
                kwicObsSubject.addObserver(output);
                // 逐步调用各个观察者
                kwicObsSubject.startKWIC();
                kwicObsSubject.notifyAllObserver();
                try {
                    String fileName = "D:\\test\\2.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("执行管道-过滤对应的体系结构代码块");
                File inFile = new File("D:\\test\\1.txt");
                File outFile = new File("D:\\test\\2.txt");
                Pipe pipe1 = new Pipe();
                Pipe pipe2 = new Pipe();
                Pipe pipe3 = new Pipe();
                Input piInput = new Input(inFile, pipe1);
                Shift piShift = new Shift(pipe1, pipe2);
                Alphabetizer piAlphabetizer  = new Alphabetizer(pipe2, pipe3);
                Output piOutput = new Output(outFile,pipe3);
                piInput.transform();
                piShift.transform();
                piAlphabetizer.transform();
                piOutput.transform();
                try {
                    String fileName = "D:\\test\\2.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("无效选择");
        }
    }
}
