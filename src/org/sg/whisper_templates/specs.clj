(ns
    org.sg.whisper-templates.specs
    (:require
     [clojure.string :as str]
     [clojure.spec.alpha :as s]))

(s/def :org.sg.whisper-template/content
  (s/and
   string?
   (complement str/blank?)
   (comp #(> 2000 %) count)))

(s/def
  :org.sg.whisper-template/title
  (s/and
   string?
   (complement str/blank?)
   (comp #(> 80 %) count)))

(s/def
  :org.sg.whisper-template/language
  (s/and
   string?
   (comp #(> 30 %) count)))

(s/def
  :org.sg.whisper/template
  (s/keys
   :req
   [:org.sg.whisper-template/language
    :org.sg.whisper-template/title
    :org.sg.whisper-template/content]))

(comment
  (s/valid?
   :org.sg.whisper/template
   #:org.sg.whisper-template
   {:content "fo"
    :title "fa"
    :language :lang-eng}
   #:org.sg.whisper-template
   {:content "fo"
    :title "ffffffffffffffffffffff"
    :language :lang-eng}))
