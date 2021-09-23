package com.code.club.challenge;

import com.code.club.challenge.util.EncryptorAesGcmPassword;
import com.code.club.challenge.util.FileUtil;
import com.code.club.challenge.util.JsonUtil;

import java.util.Optional;

public class Challenge {

    private static final boolean ACCEPTED = false;
    private static final String BANNER_VIEW = FileUtil.getFileContent("banner.txt");
    private static final String ACCEPTED_VIEW = FileUtil.getFileContent("accepted.txt");
    private static final String REJECTED_VIEW = FileUtil.getFileContent("rejected.txt");
    private static final String FAILURE_VIEW = FileUtil.getFileContent("failure.txt");

    public Challenge() {
        display(BANNER_VIEW);
        display(ACCEPTED ? ACCEPTED_VIEW : REJECTED_VIEW);
    }

    public Optional<Puzzle> getPuzzle() {
        return ACCEPTED ? Optional.of(new Puzzle()) : Optional.empty();
    }

    public boolean isAccepted() {
        return ACCEPTED;
    }

    record Puzzle() {

        public void solve(String fibonacci100thNumber) {
            if (!ACCEPTED) {
                display(REJECTED_VIEW);
            }
            var encryptedMessage = FileUtil.getFileContent("encrypted.txt");
            try {
                var decryptedMessage = EncryptorAesGcmPassword.decrypt(encryptedMessage, fibonacci100thNumber);
                display(JsonUtil.toJson(decryptedMessage));
            } catch (Exception e) {
                display(FAILURE_VIEW);
            }
        }
    }

    private static void display(String message) {
        System.out.println(message);
    }
}
