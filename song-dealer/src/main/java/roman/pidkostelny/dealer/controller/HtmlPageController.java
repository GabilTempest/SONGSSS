package roman.pidkostelny.dealer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPageController {

    @RequestMapping("/home")
    public String mainPage() {
        return "main.html";
    }

    @RequestMapping("/DemoPlayer")
    public String DemoPlayerPage() {
        return "audiojs/DemoPlayer.html";
    }


    @RequestMapping("/sing")
    public String singPage() {
        return "sing-in.html";
    }


    @RequestMapping("/Bands")
    public String RockPage() {
        return "Rock.html";
    }


    @RequestMapping("/Genre")
    public String GenrePage() {
        return "Genre.html";
    }


    @RequestMapping("/Songs")
    public String SongsIndexPage() {
        return "Songs.html";
    }


    @RequestMapping("/SongsIndex")
    public String SongsPage() {
        return "Songs.index.html";
    }


    @RequestMapping("/reGestracja")
    public String reGestracjaPage() {
        return "reGestracja.html";
    }

}

