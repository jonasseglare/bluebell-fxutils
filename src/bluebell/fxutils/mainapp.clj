(ns bluebell.fxutils.mainapp
  (:require [bluebell.fxutils.state :as state])
  (:import
    [javafx.application Application]
    [javafx.stage Stage]
    [javafx.scene Scene]
    [javafx.scene.control Button]
    [javafx.scene.layout StackPane]
    [javafx.event ActionEvent EventHandler])
  (:gen-class
    :extends javafx.application.Application))

(defn main-launch [args]
  (if (not (realized? state/top))
    (Application/launch bluebell.fxutils.mainapp args)))

(defn -main [& args]
  (main-launch args))

(defn -start [this primaryStage]
  (deliver
   state/top
   {:app this
    :primary-stage primaryStage}))

(defn start-async [& args]
  (future (main-launch args))
  (deref state/top))
