package com.code.club.challenge;

public class CodeClubApp {

    public static void main(String[] args) {
      new Challenge()
                .getPuzzle()
                .ifPresent(puzzle -> puzzle.solve("youNeedToSolveIt! ;)"));
    }
}
