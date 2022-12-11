package sh.slackscrum;

import com.slack.api.Slack;
import com.slack.api.model.ModelConfigurator;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.element.BlockElement;
import com.slack.api.model.block.element.PlainTextInputElement;
import com.slack.api.webhook.WebhookPayloads;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.element.BlockElements.*;
import static com.slack.api.webhook.WebhookPayloads.payload;
import static com.slack.api.model.block.InputBlock.*;
public class Message {

    private List<BlockElement> getActionBlocks() {
        List<BlockElement> actions = new ArrayList<>();
        System.out.println("actions = " + actions);
        actions.add(Block.getActionButton("등록", "ok", "primary", "action_submit"));
        System.out.println("actions = " + actions);
        actions.add(Block.getActionButton("취소", "fail", "danger", "action_cancel"));
        return actions;
    }

    public WebhookResponse send() throws IOException {

        List<LayoutBlock> layoutBlocks = asBlocks(
                Block.getSection("무슨 일을 하고 계신가요?"),
                divider(),
                Block.getInput(),


//                actions((List<BlockElement>) Block.getInput()),
//                InputBlock.builder().element(plainTextInput(p -> p.multiline(true).actionId("plain_text_input-action"))).build(),
//                Blocks.input((ModelConfigurator<InputBlockBuilder>) builder().build()),
//                Blocks.input(inputBlockBuilder -> inputBlockBuilder.element(
//                        plainTextInput(p -> p.multiline(true).actionId("plain_text_input-action")))),
//                Blocks.input(inputBlockBuilder -> inputBlockBuilder.build())
//                Blocks.input(inputBlockBuilder -> inputBlockBuilder.element(plainTextInput(p -> p.multiline(true)))),
                actions(getActionBlocks())
        );
//
//        layoutBlocks.add(Block.getSection("Today's Scrum"));
//        layoutBlocks.add(section(s -> s.text(markdownText("Today's Scrum"))));
//        layoutBlocks.add(divider());
//
//        layoutBlocks.add(input(inputBlockBuilder -> inputBlockBuilder.element(plainTextInput(p -> p.multiline(true).actionId("plain_text_input-action")))));
//
//        layoutBlocks.add(
//                actions(actions -> actions
//                                .elements(asElements(
//                                        button(b -> b.text(plainText(pt -> pt.emoji(true).text("등록")))
////                                        .value(deliveryTip.getSeq().toString())
//                                                        .style("primary")
//                                                        .actionId("action_submit")
//                                        ),
//                                        button(b -> b.text(plainText(pt -> pt.emoji(true).text("취소")))
//                                                .style("danger")
//                                                .actionId("action_cancel")
//                                        )
//                                ))
//                )
//        );

        return Slack.getInstance().send("https://hooks.slack.com/services/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",
                payload(p ->
                        p.text("슬랙에 메시지를 출력하지 못했습니다.").blocks(layoutBlocks)
                )
        );
    }
}
