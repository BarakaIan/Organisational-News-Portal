package models;

import org.h2.util.New;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {
    @Test
    public void NewsInstantiatesCorrectly_true(){
        News newNews = setupNews();
        News altNews = setupAltNews();
        assertTrue(newNews instanceof News);
        assertTrue(altNews instanceof News);
    }

    @Test
    public void getTitleReturnsCorrectly(){
        News newNews = setupNews();
        assertEquals("sleepless",newNews.getTitle());
    }

    @Test
    public void getContentReturnsCorrectly(){
        News newNews = setupNews();
        assertEquals("student learning java",newNews.getContent());
    }

    @Test
    public void getDepartmentIdReturnsCorrectly(){
        News newNews = setupNews();
        assertEquals(36,newNews.getDepartmentId());
    }
    @Test
    public void setTitleReturnsCorrectly(){
        News newNews = setupNews();
        String initial=newNews.getTitle();
        newNews.setTitle("Kam");
        assertNotEquals(initial,newNews.getTitle());
    }

    @Test
    public void setContentReturnsCorrectly(){
        News newNews = setupNews();
        String initial=newNews.getContent();
        newNews.setContent("Kam");
        assertNotEquals(initial,newNews.getContent());
    }

    @Test
    public void setDepartmentIdReturnsCorrectly(){
        News newNews = setupNews();
        int initial=newNews.getDepartmentId();
        newNews.setDepartmentId(37);
        assertNotEquals(initial,newNews.getDepartmentId());
    }
    
    // Helpers
    public News setupNews(){
        return new News("sleepless","student learning java",36);
    }
    public News setupAltNews(){
        return new News("sleepless","student learning java");
    }
}