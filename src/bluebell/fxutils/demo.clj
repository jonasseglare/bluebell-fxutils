(ns bluebell.fxutils.demo
  (:require [bluebell.fxutils.state :as state]
            [bluebell.fxutils.common :as common]
            [bluebell.fxutils.mainapp :as mainapp])
  (:import
   [javafx.application Application Platform]
   [javafx.stage Stage]
   [javafx.scene Scene]
   [javafx.scene.control Button]
   [javafx.scene.layout StackPane]
   [javafx.event ActionEvent EventHandler]))

(defn test-gui [this primaryStage]
  (let [root (doto (StackPane.)
               (-> (.getChildren)
                   (.add (Button. "Hello World!"))))]
    (doto primaryStage
      (.setScene (Scene. root 300 250))
      (.show))))

(defn full-demo []
  (mainapp/start-async)
  (common/set-implicit-exit false)
  (common/perform-on-root test-gui))
