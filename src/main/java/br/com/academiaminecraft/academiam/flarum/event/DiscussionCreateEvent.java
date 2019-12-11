package br.com.academiaminecraft.academiam.flarum.event;

import top.trumeet.flarumsdk.data.Discussion;

public class DiscussionCreateEvent {

   private Discussion discussion;

   public DiscussionCreateEvent(Discussion discussion) {
	  this.discussion = discussion;
   }

   public Discussion getDiscussion() {
	  return discussion;
   }
}
