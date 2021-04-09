package service;

import dao.MusicDao;
import entity.Music;

import java.util.List;

public class MusicService {
    public List<Music> findMusic(){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findMusic();
        return musicList;
    }

    public Music findMusicById(int id){
        MusicDao musicDao = new MusicDao();
        Music music = musicDao.findMusicById(id);
        return music;
    }

    public List<Music> ifMusic(String str){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.ifMusic(str);
        return musicList;
    }

    public int insert(String title, String singer, String time, String url,int userid){
        MusicDao musicDao = new MusicDao();
        int music = musicDao.insert(title,singer,time,url,userid);
        return music;
    }

    public int  deleteMusicById(int id){
        MusicDao musicDao = new MusicDao();
        int music = musicDao.deleteMusicById(id);
        return music;
    }

    public boolean insertLoveMusic(int userId,int musicId){
        MusicDao musicDao = new MusicDao();
        if(!musicDao.findMusicByMusicId(userId, musicId)){
            //如果没找到喜欢列表里里面有，就可以添加
            if (musicDao.insertLoveMusic(userId,musicId)){
                return true;
            }
        }
        return false;
    }

    public int removeLoveMusic(int userId,int musicId){
        MusicDao musicDao = new MusicDao();
        int music = musicDao.removeLoveMusic(userId,musicId);
        return music;
    }

    public  List<Music> findLoveMusic(int user_id){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findLoveMusic(user_id);
        return musicList;
    }

    public  List<Music> ifMusicLove(String str,int user_id){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.ifMusicLove(str,user_id);
        return musicList;
    }

}
