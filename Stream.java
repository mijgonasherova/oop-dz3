import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class StudyGroup {
    private String groupName;

    public StudyGroup(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return groupName;
    }
}

class Stream implements Iterable<StudyGroup> {
    private List<StudyGroup> studyGroupList;

    public Stream() {
        studyGroupList = new ArrayList<>();
    }

    public void addGroup(StudyGroup group) {
        studyGroupList.add(group);
    }

    public int groupsNum() {
        return studyGroupList.size();
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return new Iterator<StudyGroup>() {
            private int currentindex = 0;

            @Override
            public boolean hasNext() {
                return currentindex < studyGroupList.size();
            }

            @Override
            public StudyGroup next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("Нет больше учебных групп");
                }
                return studyGroupList.get(currentindex++);
            }
        };
    }
}

class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream stream1, Stream stream2) {
        return Integer.compare(stream1.groupsNum(), stream2.groupsNum());
    }
}

class StreamService {
    public void sortStreams(List<Stream> streams) {
        Collections.sort(streams, new StreamComparator());
    }

    public void outStreams(List<Stream> streams) {
        for (Stream stream : streams) {
            System.out.println("Поток с группами: " + stream.groupsNum());
        }
    }
}

class Controller {
    private StreamService streamService;
    private List<Stream> streams;

    public Controller() {
        streamService = new StreamService();
        streams = new ArrayList<>();
    }

    public void addStream(Stream stream) {
        streams.add(stream);
    }

    public void sortStreams() {
        streamService.sortStreams(streams);
    }

    public void outStreams() {
        streamService.outStreams(streams);
    }
}

