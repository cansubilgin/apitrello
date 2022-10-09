package trello.com;
import org.testng.annotations.Test;


public class Cases extends Method {

    @Test
    public void postExample () {
        String getBoardId=createBoard();
        String getId= createTask(getBoardId);
        deleteTask(getId);

//        postMethod();
    }
}
