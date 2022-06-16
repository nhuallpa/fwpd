(ns fwpd.core)
(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
        (clojure.string/split string #"\n")))


(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map  (fn [unmapped-row]
          (reduce (fn [row-map [vamp-key value]]
                    (assoc row-map vamp-key (convert vamp-key value))) 
            {} 
            (map vector vamp-keys unmapped-row))) 
        rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

;; Write a function, append, which will append a new suspect to your list of suspects.
(def suspects (glitter-filter 3 (mapify (parse (slurp filename)))))

(defn append
  [suspects & other-suspects]
  (into suspects other-suspects))

(append suspects {:name "Carlos", :glitter-index 1} {:name "Diego", :glitter-index 3})

;; Write a function, validate, which will check that :name and :glitter-index are present 
;; when you append. The validate function should accept two arguments: a map of keywords 
;; to validating functions, similar to conversions, and the record to be validated.

(defn not-exist?
  [value]
  (not (nil? value)))

(def validators {:name not-exist?
                 :glitter-index not-exist?})

(defn validate
  " Validate suspect structure {:name aName :glitter-index aNumber} but not type
  validators : A map of keys to validator's functions
  suspect    : A map structure to validate"
  [validators suspect]
  (reduce (fn [valid [key validator]]
            (and valid (validator (and (get suspect key) key)))) 
          true
          validators)) ; revisar

(validate validators {:name "Carlos", :glitter-index 1})