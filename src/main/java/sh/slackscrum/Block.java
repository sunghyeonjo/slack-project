package sh.slackscrum;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElement;
import com.slack.api.model.block.element.BlockElements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;
import static com.slack.api.model.block.element.BlockElements.plainTextInput;

public class Block {
    public static LayoutBlock getHeader(String text) {
        return Blocks.header(h -> h.text(
                plainText(pt -> pt.emoji(true)
                        .text(text))));
    }

    public static LayoutBlock getSection(String message) {
        return Blocks.section(s -> s.text(
                BlockCompositions.markdownText(message)));
    }

    public static InputBlock getInput() {
        return Blocks.input(inputBlockBuilder -> inputBlockBuilder.element(
                plainTextInput(p -> p.multiline(true).actionId("plain_text_input-action"))).label(plainText("아무거나")));
//        return plainTextInput(i -> i.multiline(true).actionId("plain_text_input-action").placeholder(plainText("내용을 입력하세요.")).focusOnLoad(true));
    }

    public static BlockElement getActionButton(String plainText, String value, String style, String actionId) {
        return BlockElements.button(b -> b.text(plainText(plainText, true))
                .value(value)
                .style(style)
                .actionId(actionId));
    }
}
