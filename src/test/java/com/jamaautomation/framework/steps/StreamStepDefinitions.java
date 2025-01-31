package com.jamaautomation.framework.steps;

import com.jamaautomation.framework.pages.StreamPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StreamStepDefinitions {

    @Then("I validate a comment is correctly added")
    public void IValidateACommentIsCorrectlyAdded()
    {
        StreamPage streamPage = new StreamPage(Hooks.driver);
        streamPage.clickAddCommentInteractive();
        String comment = streamPage.addComment();
        streamPage.clickAddCommentButton();
        String firstComment = streamPage.getCommentTextByIndex(0,comment);
        Assert.assertEquals("Comment was not added", firstComment, comment);
    }
}
