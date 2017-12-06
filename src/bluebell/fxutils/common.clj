(ns bluebell.fxutils.common
  (:require [bluebell.fxutils.state :as state])
  (:import
    [javafx.application Application Platform]))

(defn set-implicit-exit [value]
  (Platform/setImplicitExit value))

(defn perform-on-root [f]
  (Platform/runLater
   (fn []
     (let [x (deref state/top)]
       (f (:app x) (:primary-stage x))))))


