package dao;

import entity.Music;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * MusicDao 单元测试
 */
public class MusicDaoTest {
    @After
    public void after(){
        System.out.println("--------------after--------------");
    }

    @Before
    public void before(){
        System.out.println("--------------before--------------");
    }


    @org.junit.Test
    public void findMusic() {
        MusicDao musicDao = new MusicDao();
        List<Music> music = new ArrayList<>();
        music = musicDao.findMusic();
        System.out.println(music);
    }

    @Test
    public void findMusicById() {
        MusicDao musicDao = new MusicDao();
        Music music = new Music();
        music = musicDao.findMusicById(36);
        System.out.println(music);
    }

    @Test
    public void ifMusic() {
        MusicDao musicDao = new MusicDao();
        List<Music> music = new ArrayList<>();
        music = musicDao.ifMusic("十");
        System.out.println(music);
    }

    @Ignore //表示不执行这个单元测试
    @Test
    public void deleteMusicById() {
        MusicDao musicDao = new MusicDao();
        int musicById = musicDao.deleteMusicById(36);
        System.out.println(musicById);
    }

    @Ignore //表示不执行这个单元测试
    @Test
    public void insertLoveMusic() {
        MusicDao musicDao = new MusicDao();
        boolean b = musicDao.insertLoveMusic(1,1);
        System.out.println(b);
    }

    @Test
    public void findMusicByMusicId() {
        MusicDao musicDao = new MusicDao();
        boolean b = musicDao.findMusicByMusicId(1,36);
        System.out.println(b);
    }

    @Ignore //表示不执行这个单元测试
    @Test
    public void removeLoveMusic() {
        MusicDao musicDao = new MusicDao();
        int i = musicDao.removeLoveMusic(1,3);
        System.out.println(i);
    }

    @Test
    public void findLoveMusic() {
        MusicDao musicDao  = new MusicDao();
        List<Music> musicList = musicDao.findLoveMusic(1);
        System.out.println(musicList);
    }

    @Test
    public void ifMusicLove() {
        MusicDao musicDao = new MusicDao();
        List<Music> music = new ArrayList<>();
        music = musicDao.ifMusicLove("十",1);
        System.out.println(music);
    }
}