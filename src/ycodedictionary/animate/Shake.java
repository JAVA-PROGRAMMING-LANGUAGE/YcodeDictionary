/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycodedictionary.animate;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author YCODE
 */
public class Shake extends AnimationFX {

    /**
     *
     * Create new Shake
     *
     *
     *
     * @param node The node to affect
     *
     */
    public Shake(Node node) {

        super(node);

    }

    public Shake() {

    }

    @Override

    AnimationFX resetNode() {

        return this;

    }

    @Override

    void initTimeline() {

        setTimeline(new Timeline(
                new KeyFrame(Duration.INDEFINITE.millis(0),
                        new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(100),
                        new KeyValue(getNode().translateXProperty(), -10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(200),
                        new KeyValue(getNode().translateXProperty(), 10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(300),
                        new KeyValue(getNode().translateXProperty(), -10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(400),
                        new KeyValue(getNode().translateXProperty(), 10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(500),
                        new KeyValue(getNode().translateXProperty(), -10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(600),
                        new KeyValue(getNode().translateXProperty(), 10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(700),
                        new KeyValue(getNode().translateXProperty(), -10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(800),
                        new KeyValue(getNode().translateXProperty(), 10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(900),
                        new KeyValue(getNode().translateXProperty(), -10, AnimateFXInterpolator.EASE)
                ),
                new KeyFrame(Duration.millis(1000),
                        new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE)
                )
        ));

    }

}
