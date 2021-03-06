    package controller;

    import com.example.demoTwitter.model.Tweet;
    import com.example.demoTwitter.model.User;
    import com.example.demoTwitter.service.TweetService;
    import com.example.demoTwitter.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;

    import javax.validation.Valid;
    import java.util.List;

    @Controller
    public class TweetController {
        @Autowired
        private UserService userService;

        private TweetService tweetService;

        @GetMapping(value = {"/tweets", "/"})
        public String getFeed(Model model) {
            List<Tweet> tweets = tweetService.findAll();
            return "feed";
        }

        @GetMapping(value = "/tweets/new")
        public String getTweetForm(Model model) {
           //
            // model.addAttribute(attributeName, "tweet", new Tweet());
            return "newTweet";
        }

        @PostMapping(value = "/tweets")
        public String submitTweetForm(@Valid Tweet tweet, BindingResult bindingResult, Model model) {

        User user = userService.getLoggedInUser();
                if(!bindingResult.hasErrors())
                        tweet.setUser(user);
                    tweetService.save(tweet);
                    model.addAttribute("successMessage"),attributeValue:"Tweet Successfully Created";
                    model.addAttribute(attributeName, "tweet", new Tweet());
    }
            return "newTweet";
    }




