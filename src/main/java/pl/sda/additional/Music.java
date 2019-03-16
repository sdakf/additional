package pl.sda.additional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Music extends Playable {
    private String title;
    private String author;




    @Override
    public String play() {
        return "Muzyka " + title + "Autor " + author;
    }
}
