package pl.sda.additional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Playlist extends Playable {
    private List<Playable> playablesList = new ArrayList<>();
    private PlayMode playMode;


    public void addPlayable(Playable playable) {
        playablesList.add(playable);
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }


    @Override
    public String play() {
        if (playMode == PlayMode.LOOP) {

        } else if (playMode == PlayMode.SEQUENTIAL){
            return preparePlayableList(playablesList);
        }else{
            List<Playable> shuffleList = new ArrayList<>(playablesList);
            Collections.shuffle(shuffleList);
           return preparePlayableList(shuffleList);
        }

        return null;

    }

    private String preparePlayableList(List<Playable> shuffleList) {
        return shuffleList.stream()
                .map(x -> x.play())
                .collect(Collectors.joining("\n"));
    }
}
