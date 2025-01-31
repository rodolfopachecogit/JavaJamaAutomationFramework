package com.jamaautomation.framework.pages;

import com.jamaautomation.framework.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class StreamPage extends BasePage{

    // Locators
    private final By addCommentInteractive = By.xpath("//div[@class='add-comment-interactions']");
    private final By addCommentField = By.id("js-add-comment-field");
    private final By addCommentButton = By.xpath("//button[contains(@class,'add-comment')]");

    // Methods
    public StreamPage(WebDriver driver) {
        super(driver);
    }

    /// <summary>
    /// Generates a list of locators based on the provided text.
    /// </summary>
    /// <param name="text">The dynamic text to include in the locator.</param>
    /// <returns>A list of By locators.</returns>
    public static List<By> getCommentsList(String text) {
        return Collections.singletonList(
                By.xpath("//div[@class='js-root-comment-text-wrapper']/p[text()='" + text + "']")
        );
    }

    public String addComment(){
        String comment = "Comment" + StringUtils.generateRandomString(10);
        enterText(addCommentField,comment);
        return comment;
    }

    public void clickAddCommentInteractive(){
        clickElement(addCommentInteractive);
    }

    public void clickAddCommentButton(){
        clickElement(addCommentButton);
    }

    /**
     * Retrieves a locator by a specific index.
     * @param index The index of the locator in the list.
     * @param text The text of the comment.
     * @return The specific By locator.
     */
    public By getLocator(int index, String text) {
        List<By> dynamicCommentsList = getCommentsList(text);

        if (index >= 0 && index < dynamicCommentsList.size()) {
            return dynamicCommentsList.get(index);
        }

        throw new IndexOutOfBoundsException("Invalid index for the dynamic comments list.");
    }

    /**
     * Gets the text of a comment based on a specific index.
     * @param index The index of the comment.
     * @param comment The text of the comment.
     * @return The visible text of the comment.
     */
    public String getCommentTextByIndex(int index, String comment) {
        By specificLocator = getLocator(index, comment);

        // Wait for the element to be visible
        WebElement element = waitHelper.waitForElementToBeVisible(specificLocator);

        // Return the text of the visible element
        return element.getText();
    }
}
