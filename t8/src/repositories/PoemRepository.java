package repositories;

import java.util.*;
import java.util.Map.Entry;

import model.Poem;

public class PoemRepository {
    private Map<String, Poem> poems = new HashMap<>();

    public PoemRepository() {
    }

    public PoemRepository(List<String> files) {
        this.addFiles(files);
    }

    public void addPoem(Poem poem) {
        poems.put(poem.getFilePath(), poem);
    }

    public void addPoems(List<Poem> poems) {
        for (Poem poem : poems) {
            this.poems.put(poem.getFilePath(), poem);
        }
    }

    public void addFiles(List<String> files) {
        for (String file : files) {
            Poem poem = new Poem(file);
            poems.put(file, poem);
        }
    }

    public Map<String, Poem> getPoems() {
        return new HashMap<>(poems);
    }

    public Map<String, Poem> search(String keyword) {
        Map<String, Poem> filter = new HashMap<>();
        for (Object key : poems.keySet()) {
            if (poems.get(key).contains(keyword))
                filter.put((String) key, poems.get(key));
        }
        return filter;
    }
}
