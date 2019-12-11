package br.com.academiaminecraft.academiam.flarum.listener;

import br.com.academiaminecraft.academiam.flarum.event.DiscussionCreateEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import top.trumeet.flarumsdk.data.Discussion;

public class ForumListener {

   @Subscribe(threadMode = ThreadMode.ASYNC)
   public void onCreatDiscussion(DiscussionCreateEvent event){
	  Discussion discussion = event.getDiscussion();
	  // manda o embed com as infomrações do novo tópico.
   }

}
