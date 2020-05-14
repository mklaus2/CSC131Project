public class User {
    private String username;
    private Nominee[] watchlist = null;
    private String[] current_votes;
    private boolean admin;

    public User(String username, boolean admin){
        this.username = username;
        this.admin = admin;
    }

    public void add_watchlist(Nominee N){
        if(watchlist == null) {
            watchlist = new Nominee[5];
            watchlist[0] = N;
            return;
        }

        if(watchlist[watchlist.length - 1] != null){
            Nominee[] temp = new Nominee[watchlist.length + 5];

            for(int i = 0; i < watchlist.length; i++){
                temp[i] = watchlist[i];
            }

            temp[watchlist.length] = N;
            watchlist = temp;

            return;
        }

        for(int i = 1; i < watchlist.length; i++){
            if(watchlist[i] == null){
                watchlist[i] = N;
                return;
            }
        }
    }

    public void add_vote(Nominee N){

    }

    public String toString(){
        return (admin?"Admin ":"User ") + username;
    }

    public int total_watched(){
        int count = 0;

        for(int i = 0; i < watchlist.length; i++){
            if(watchlist[i] != null){
                count++;
            }
        }

        return count;
    }

    public Nominee[] get_watchlist(){
        return watchlist;
    }

    public String get_username(){
        return username;
    }

    public boolean is_admin(){
        return admin;
    }

    public void change_admin(){
        admin = !admin;
    }

}
