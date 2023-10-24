public class KWICObsSubject extends ObsSubject {
    public void startKWIC(){
        for (int i = 0;i < 3;i++){
            super.notifyOneObserver(i);
        }
    }
}

