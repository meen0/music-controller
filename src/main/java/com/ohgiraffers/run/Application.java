package com.ohgiraffers.run;

import com.ohgiraffers.common.MusicDTO;
import com.ohgiraffers.common.Search;
import com.ohgiraffers.controller.MusicController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicController musicController = new MusicController();
        do {

            System.out.println("=======메뉴 선택=========");
            System.out.println("1. 전체 노래 조회");
            System.out.println("2. 노래 검색");
            System.out.println("3. 노래 추가");
            System.out.println("4. 노래 수정");
            System.out.println("5. 노래 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    musicController.selectAllMusic();
                    break;
                case 2:
                    musicController.SearchMusic(SearchSubMenu());
                    break;
                case 3 : musicController.registMusic(inputRegistMusic());
                case 9:
                    return;
            }

        } while (true);


    }


    private static Map<String, Object> SearchSubMenu() {
        Search search = new Search();
        MusicController musicController = new MusicController();
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하세요(singer, musicName, all) : ");
        String condition = sc.nextLine();
        Map<String, Object> abc = new HashMap<>();

        if (condition.equals("singer")) {
            System.out.print("검색할 가수 명을 입력하세요 : ");
            String value = sc.nextLine();
            abc.put("singer", value);
        } else if (condition.equals("musicName")) {
            System.out.print("검색할 노래 제목을 입력하세요 : ");
            String value = sc.nextLine();
            abc.put("name", value);
        } else if (condition.equals("category")) {
            System.out.print("검색할 카테고리를 입력하세요 : ");
            int no = sc.nextInt();
            abc.put("category", no);
        } else if (condition.equals("all")) {
            System.out.print("검색할 가수 명을 입력하세요 : ");
            String value = sc.nextLine();
            System.out.print("검색할 노래 제목을 입력하세요 : ");
            String value2 = sc.nextLine();
            abc.put("singer", value);
            abc.put("name", value2);
        }
        return abc;
    }

    private static MusicDTO inputRegistMusic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 노래 제목 : ");
        String musicName = sc.nextLine();
        System.out.println("추가할 노래 가수명 :");
        String singer = sc.nextLine();
        System.out.println("추가할 노래 카테고리코드 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.println("재생 가능 여부(Y/N) : ");
        String playable = sc.nextLine();

        MusicDTO music = new MusicDTO();
        music.setName(musicName);
        music.setPlayAbleStatus(playable);
        music.setSinger(singer);
        music.setCategoryCode(categoryCode);

        return music;
    }


}
