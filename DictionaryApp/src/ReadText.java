
import com.sun.speech.freetts.VoiceManager; // cái này phải tải thư viện freetts về và import vào //project.

public class ReadText {

    public static void main(String[] args) {
        speech("good morning");
    }

    public static void speech(String text) {
        VoiceManager voiceManager = VoiceManager.getInstance();
// gọi đến giọng của thằng có tên là kevin 16, có thằng khác tên là kevin và một thằng tên
// là anna hay gì đó mình không nhớ!
        com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("kevin16");
        syntheticVoice.allocate();
        syntheticVoice.speak(text);
        syntheticVoice.deallocate();
    }
}
