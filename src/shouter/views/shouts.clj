(ns shouter.views.shouts
  (:require [shouter.views.layout :as layout]
            [hiccup.core :refer [h]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :as anti-forgery]))

(defn shout-form []
  [:div {:id "shout-form" :class "sixteen column alpha omega"}
    (form/form-to [:post "/"]
                  (anti-forgery/anit-forger-field)
                  (form/label "shout" "What do you want to SHOUT?")
                  (form/text-area "shout")
                  (form/submit-button "SHOUT!"))])

(defn display-shouts [shouts]
  [:div {:class "shouts sixteen column alpha omega"}
    (map
      (fn [shout] [:h2 {:class "shout"} (h (:body shout))])
      shouts)])

(defn index [shouts]
  (layout/common "SHOUTER"
                  (shout-form)
                  [:div {:class "clear"}]
                  (display-shouts shouts)))
