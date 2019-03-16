package pl.sda.additional;

public class PlayListMain {
    public static void main(String[] args) {
        Music music1 = new Music("Firestarer", "Prodigy");
        Music music2 = new Music("Tour de France", "Kraftwerk");
        Music music3 = new Music("Air bug", "Radiohead");
        Music music4 = new Music("Beautiful day", "U2");
        Music music5 = new Music("GO", "Chemical Brothers");

        Movie movie1 = new Movie("Interstellar");
        Movie movie2 = new Movie("Grawitacja");
        Movie movie3 = new Movie("First Contact");
        Movie movie4 = new Movie("Seksmisja");
        Movie movie5 = new Movie("Alien");

        Playlist playlist = new Playlist();
        playlist.setPlayMode(PlayMode.SEQUENTIAL);
        playlist.addPlayable(music1);
        playlist.addPlayable(music2);
        playlist.addPlayable(music3);
        playlist.addPlayable(movie1);
        playlist.addPlayable(movie2);
        playlist.addPlayable(movie3);

        Playlist subPlaylist = new Playlist();
        subPlaylist.setPlayMode(PlayMode.SHUFFLE);
        subPlaylist.addPlayable(music4);
        subPlaylist.addPlayable(music5);
        subPlaylist.addPlayable(movie4);
        subPlaylist.addPlayable(movie5);
        playlist.addPlayable(subPlaylist);

        System.out.println(playlist.play());



    }
}
