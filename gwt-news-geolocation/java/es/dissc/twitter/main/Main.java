package es.dissc.twitter.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.social.connect.Connection;
import org.springframework.social.twitter.api.DirectMessage;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class Main {

	/**
	 * 
	 * Programa Principal 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {		
		
		// Configuracion PROXY. Para conectarse correctamente este necesario configurar el PROXY.
        System.setProperty("http.proxySet","true");
        System.setProperty("http.proxyHost","10.14.79.204");
        System.setProperty("http.proxyPort","8080");
        System.setProperty("http.proxyUser","");
        System.setProperty("http.proxyPassword","");
        
        
		String consumerKey = "oP87hLvFOnQbooflaXz7g"; // The application's consumer key
		String consumerSecret = "g7aUG8Wq4fdfaxZNGvNrMo48bH8gBWw1KAvYFYJMTE"; // The application's consumer secret
		String accessToken = "555105606-zdBywM6GJr2jraMMgpw3MKs9OSgc8wBGmqRRb5vw"; // The access token granted after OAuth authorization
		String accessTokenSecret = "Aqk6quN4hJtvUNeBaUNTtugsyF1j7ylXArxtyMKcdk"; // The access token secret granted after OAuth authorization
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		
		
/*		
		Connection<Twitter> connection = connectionRepository.findPrimaryConnection(Twitter.class);
		Twitter twitter = connection != null ? connection.getApi() : new TwitterTemplate();
		*/ 			
		
		
		//  Retrieving a user's Twitter profile data
		TwitterProfile profile = twitter.userOperations().getUserProfile();		
		System.out.println("Profile:          " + profile.getId());
		System.out.println("Profile Url:      " + profile.getProfileUrl());
		System.out.println("Profile ImageUrl: " + profile.getProfileImageUrl());
		System.out.println("Profile Description: " + profile.getDescription());
		
		
		// Tweeting =====

		
		// Reading Twitter timelines =====
		
		// Friends and Followers =====
		
		// Twitter User Lists =====
		
		// Searching Twitter =====
		SearchResults results = twitter.searchOperations().search("#spring");
		for (Tweet tweet : results.getTweets()) {
			System.out.println("Tweet " + tweet.getText());
		}
		
		
		// Sending and receiving direct messages =====
		List<DirectMessage> list = twitter.directMessageOperations().getDirectMessagesReceived();
		System.out.println("Lista " + list.size());
	
	}

}
