package com.roobi.pulpy;
import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.json.JSONObject;

import com.semantics3.api.Products;

public class FlickrExample {

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		try {
			Products products = new Products(
					"SEM3694554054990A563752AF2A49CEF2199",
					"YzZmYjc0YWRmYjlkMGUzNzk3NDhmZDdmZTA2ODU2Yzg"
				);
			products
			.field( "cat_id", 4992 )	
			.field( "brand", "Toshiba" );
			JSONObject results;	
			results = products.get();
			System.out.println(results.toString(4));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}