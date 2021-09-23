package com.code.club.challenge;

import com.code.club.challenge.util.EncryptorAesGcmPassword;
import com.code.club.challenge.util.FileUtil;
import com.code.club.challenge.util.JsonUtil;

import java.util.Optional;

public class Challenge {

    private static final boolean ACCEPTED = false;

    public Challenge() {
        display(FileUtil.getFileContent("banner.txt"));
        display(ACCEPTED ?
                FileUtil.getFileContent("accepted.txt") :
                FileUtil.getFileContent("rejected.txt"));
    }

    public Optional<Puzzle> getPuzzle() {
        return ACCEPTED ? Optional.of(new Puzzle()) : Optional.empty();
    }

    public boolean isAccepted() {
        return ACCEPTED;
    }

    record Puzzle() {

        public void solve(String fibonacci100thNumber) {
            var encryptedMessage = FileUtil.getFileContent("encrypted.txt");
            try {
                var decryptedMessage = EncryptorAesGcmPassword.decrypt(encryptedMessage, fibonacci100thNumber);
                display(JsonUtil.toJson(decryptedMessage));
            } catch (Exception e) {
                display(FileUtil.getFileContent("failure.txt"));
            }
        }
    }

    private static void display(String message) {
        System.out.println(message);
    }
}
