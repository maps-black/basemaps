package com.protomaps.basemap.names;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.reader.SourceFeature;
import com.protomaps.basemap.text.FontRegistry;
import com.protomaps.basemap.text.TextEngine;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class OsmNames {

  private OsmNames() {}

  private static final String[] ALLOWED_LANGS = new String[]{
    "aa",
    "aae",
    "ab",
    "abs",
    "ace",
    "acf",
    "acm",
    "ady-cyrl",
    "ady",
    "aeb-arab",
    "aeb-latn",
    "aeb",
    "af",
    "agq",
    "ak",
    "aln",
    "als",
    "alt",
    "am",
    "ami",
    "an",
    "ang",
    "ann",
    "anp",
    "apc",
    "ar", // Arabic
    "arc",
    "arn",
    "arq",
    "ary",
    "arz",
    "as",
    "ase",
    "ast",
    "atj",
    "av",
    "avk",
    "awa",
    "ay",
    "az",
    "azb",
    "ba",
    "bag",
    "ban-bali",
    "ban",
    "bar",
    "bas",
    "bat-smg",
    "bax",
    "bbc-latn",
    "bbc",
    "bbj",
    "bcc",
    "bci",
    "bcl",
    "bdr",
    "be-tarask",
    "be-x-old",
    "be",
    "bew",
    "bfd",
    "bg", // Bulgarian
    "bgc",
    "bgn",
    "bh",
    "bho",
    "bi",
    "bjn",
    "bkc",
    "bkh",
    "bkm",
    "blk",
    "bm",
    "bn",
    "bo",
    "bpy",
    "bqi",
    "bqz",
    "br",
    "brh",
    "bs",
    "btm",
    "bto",
    "bug",
    "bxr",
    "byv",
    "ca",
    "cak",
    "cal",
    "cbk-zam",
    "ccp",
    "cdo-hant",
    "cdo-latn",
    "cdo",
    "ce",
    "ceb",
    "ch",
    "chn",
    "cho",
    "chr",
    "chy",
    "ckb",
    "cnh",
    "co",
    "cop",
    "cps",
    "cpx-hans",
    "cpx-hant",
    "cpx-latn",
    "cpx",
    "cr",
    "crh-cyrl",
    "crh-latn",
    "crh-ro",
    "crh",
    "cs", // Czech
    "csb",
    "cu",
    "cv",
    "cy",
    "da", // Danish
    "dag",
    "de-at",
    "de-ch",
    "de-formal",
    "de", // German
    "dga",
    "din",
    "diq",
    "dsb",
    "dtp",
    "dty",
    "dua",
    "dv",
    "dz",
    "ee",
    "efi",
    "egl",
    "el", // Greek
    "eml",
    "en-ca",
    "en-gb",
    "en-us",
    "en", // English
    "eo",
    "es-419",
    "es-formal",
    "es", // Spanish
    "et", // Estonian
    "eto",
    "etu",
    "eu",
    "ewo",
    "ext",
    "fa", // Persian
    "fat",
    "ff",
    "fi", // Finnish
    "fit",
    "fiu-vro",
    "fj",
    "fkv",
    "fmp",
    "fo",
    "fon",
    "fr", // French
    "frc",
    "frp",
    "frr",
    "fur",
    "fvr",
    "fy",
    "ga", // Irish
    "gaa",
    "gag",
    "gan-hans",
    "gan-hant",
    "gan",
    "gcf",
    "gcr",
    "gd",
    "gl",
    "gld",
    "glk",
    "gn",
    "gom-deva",
    "gom-latn",
    "gom",
    "gor",
    "got",
    "gpe",
    "grc",
    "gsw",
    "gu",
    "guc",
    "gur",
    "guw",
    "gv",
    "gya",
    "ha",
    "hak-hans",
    "hak-hant",
    "hak-latn",
    "hak",
    "haw",
    "he", // Hebrew
    "hi", // Hindi
    "hif-latn",
    "hif",
    "hil",
    "hke",
    "hno",
    "ho",
    "hr", // Croatian
    "hrx",
    "hsb",
    "hsn",
    "ht",
    "hu-formal",
    "hu", // Hungarian
    "hy",
    "hyw",
    "hz",
    "ia",
    "iba",
    "ibb",
    "id", // Indonesian
    "ie",
    "ig",
    "igl",
    "ii",
    "ik",
    "ike-cans",
    "ike-latn",
    "ilo",
    "inh",
    "io",
    "is",
    "isu",
    "isv-cyrl",
    "isv-latn",
    "it", // Italian
    "iu",
    "ja", // Japanese
    "jam",
    "jbo",
    "jut",
    "jv",
    "ka",
    "kaa",
    "kab",
    "kai",
    "kbd-cyrl",
    "kbd",
    "kbp",
    "kcg",
    "kea",
    "ker",
    "kg",
    "kge",
    "khw",
    "ki",
    "kiu",
    "kj",
    "kjh",
    "kjp",
    "kk-arab",
    "kk-cn",
    "kk-cyrl",
    "kk-kz",
    "kk-latn",
    "kk-tr",
    "kk",
    "kl",
    "km",
    "kn",
    "knc",
    "ko-kp",
    "ko", // Korean
    "koi",
    "kr",
    "krc",
    "kri",
    "krj",
    "krl",
    "ks-arab",
    "ks-deva",
    "ks",
    "ksf",
    "ksh",
    "ksw",
    "ku-arab",
    "ku-latn",
    "ku",
    "kum",
    "kus",
    "kv",
    "kw",
    "ky",
    "la",
    "lad",
    "lb",
    "lbe",
    "lem",
    "lez",
    "lfn",
    "lg",
    "li",
    "lij",
    "liv",
    "lki",
    "lld",
    "lmo",
    "ln",
    "lns",
    "lo",
    "loz",
    "lrc",
    "lt", // Lithuanian
    "ltg",
    "lua",
    "lus",
    "luz",
    "lv", // Latvian
    "lzh",
    "lzz",
    "mad",
    "mag",
    "mai",
    "map-bms",
    "mcn",
    "mcp",
    "mdf",
    "mg",
    "mh",
    "mhr",
    "mi",
    "min",
    "mk",
    "ml",
    "mn",
    "mnc-latn",
    "mnc-mong",
    "mnc",
    "mni",
    "mnw",
    "mo",
    "mos",
    "mr", // Marathi
    "mrh",
    "mrj",
    "ms-arab",
    "ms",
    "mt", // Maltese
    "mua",
    "mui",
    "mul",
    "mus",
    "mwl",
    "my",
    "myv",
    "mzn",
    "na",
    "nah",
    "nan-hani",
    "nan-hant",
    "nan-latn-pehoeji",
    "nan-latn-tailo",
    "nan",
    "nap",
    "nb",
    "nds-nl",
    "nds",
    "ne", // Nepali
    "new",
    "ng",
    "nge",
    "nia",
    "nit",
    "niu",
    "nl-informal",
    "nl", // Dutch
    "nla",
    "nmg",
    "nmz",
    "nn",
    "nnh",
    "nnz",
    "no", // Norwegian
    "nod",
    "nog",
    "nov",
    "nqo",
    "nr",
    "nrm",
    "nso",
    "nup",
    "nv",
    "ny",
    "nyn",
    "nyo",
    "nys",
    "oc",
    "ojb",
    "olo",
    "om",
    "or",
    "os",
    "osa-latn",
    "ota",
    "pa",
    "pag",
    "pam",
    "pap-aw",
    "pap",
    "pcd",
    "pcm",
    "pdc",
    "pdt",
    "pfl",
    "pi",
    "pih",
    "pl", // Polish
    "pms",
    "pnb",
    "pnt",
    "prg",
    "ps",
    "pt-br",
    "pt", // Portuguese
    "pwn",
    "qu",
    "quc",
    "qug",
    "rgn",
    "rif",
    "rki",
    "rm",
    "rmc",
    "rmf",
    "rmy",
    "rn",
    "ro", // Romanian
    "roa-rup",
    "roa-tara",
    "rsk",
    "ru", // Russian
    "rue",
    "rup",
    "ruq-cyrl",
    "ruq-latn",
    "ruq",
    "rut",
    "rw",
    "rwr",
    "ryu",
    "sa",
    "sah",
    "sat",
    "sc",
    "scn",
    "sco",
    "sd",
    "sdc",
    "sdh",
    "se-fi",
    "se-no",
    "se-se",
    "se",
    "sei",
    "ses",
    "sg",
    "sgs",
    "sh-cyrl",
    "sh-latn",
    "sh",
    "shi-latn",
    "shi-tfng",
    "shi",
    "shn",
    "shy-latn",
    "shy",
    "si",
    "simple",
    "sjd",
    "sje",
    "sju",
    "sk", // Slovak
    "skr-arab",
    "skr",
    "sl", // Slovenian
    "sli",
    "sm",
    "sma",
    "smj",
    "smn",
    "sms",
    "sn",
    "so",
    "sq",
    "sr-ec",
    "sr-el",
    "sr",
    "srn",
    "sro",
    "srq",
    "ss",
    "st",
    "stq",
    "sty",
    "su",
    "sv", // Swedish
    "sw",
    "syl",
    "szl",
    "szy",
    "ta",
    "tay",
    "tcy",
    "tdd",
    "te",
    "tet",
    "tg-cyrl",
    "tg-latn",
    "tg",
    "th",
    "ti",
    "tig",
    "tk",
    "tl",
    "tly-cyrl",
    "tly",
    "tn",
    "to",
    "tok",
    "tpi",
    "tpv",
    "tr", // Turkish
    "tru",
    "trv",
    "ts",
    "tt-cyrl",
    "tt-latn",
    "tt",
    "ttj",
    "tum",
    "tvu",
    "tw",
    "ty",
    "tyv",
    "tzm",
    "udm",
    "ug-arab",
    "ug-latn",
    "ug",
    "uk", // Ukrainian
    "ur", // Urdu
    "uz-cyrl",
    "uz-latn",
    "uz",
    "ve",
    "vec",
    "vep",
    "vi", // Vietnamese
    "vls",
    "vmf",
    "vmw",
    "vo",
    "vot",
    "vro",
    "vut",
    "wa",
    "wal",
    "war",
    "wes",
    "wls",
    "wo",
    "wuu-hans",
    "wuu-hant",
    "wuu",
    "wya",
    "xal",
    "xh",
    "xmf",
    "xsy",
    "yas",
    "yat",
    "yav",
    "ybb",
    "yi",
    "yo",
    "yrl",
    "yue-hans",
    "yue-hant",
    "yue",
    "za",
    "zea",
    "zgh-latn",
    "zgh",
    "zh-classical",
    "zh-cn",
    "zh-Hans", // Chinese (Simplified)
    "zh-Hant", // Chinese (Traditional)
    "zh-hk",
    "zh-min-nan",
    "zh-mo",
    "zh-my",
    "zh-sg",
    "zh-tw",
    "zh-yue",
    "zh",
    "zu"
  };

  private static final Set<String> ALLOWED_LANG_SET =
    new HashSet<>(Stream.of(ALLOWED_LANGS).map(s -> "name:" + s).toList());

  public static boolean isAllowed(String osmKey) {
    return ALLOWED_LANG_SET.contains(osmKey);
  }

  public static FeatureCollector.Feature setOsmNames(FeatureCollector.Feature feature, SourceFeature sf,
    int minZoom) {
    FontRegistry fontRegistry = FontRegistry.getInstance();
    for (Map.Entry<String, Object> tag : sf.tags().entrySet()) {
      var key = tag.getKey();
      String value = sf.getTag(key).toString();
      var script = Script.getScript(value);

      if (key.equals("name")) {
        List<String> segments = ScriptSegmenter.segmentByScript(value);
        if (!segments.isEmpty()) {
          int index = 0;
          feature.setAttrWithMinzoom("name", segments.get(index), minZoom);

          script = Script.getScript(segments.get(index));

          if (!script.equals("Latin") && !script.equals("Generic")) {
            feature.setAttrWithMinzoom("script", script, minZoom);
          }

          String encodedValue = TextEngine.encodeRegisteredScripts(segments.get(index));
          if (!encodedValue.equals(segments.get(index))) {
            feature.setAttrWithMinzoom("pgf:name", encodedValue, minZoom);
          }
        }
        if (segments.size() >= 2) {
          int index = 1;
          feature.setAttrWithMinzoom("name2", segments.get(index), minZoom);

          script = Script.getScript(segments.get(index));

          if (!script.equals("Latin") && !script.equals("Generic")) {
            feature.setAttrWithMinzoom("script2", script, minZoom);
          }

          String encodedValue = TextEngine.encodeRegisteredScripts(segments.get(index));
          if (!encodedValue.equals(segments.get(index))) {
            feature.setAttrWithMinzoom("pgf:name2", encodedValue, minZoom);
          }
        }
        if (segments.size() >= 3) {
          int index = 2;
          feature.setAttrWithMinzoom("name3", segments.get(index), minZoom);

          script = Script.getScript(segments.get(index));

          if (!script.equals("Latin") && !script.equals("Generic")) {
            feature.setAttrWithMinzoom("script3", script, minZoom);
          }

          String encodedValue = TextEngine.encodeRegisteredScripts(segments.get(index));
          if (!encodedValue.equals(segments.get(index))) {
            feature.setAttrWithMinzoom("pgf:name3", encodedValue, minZoom);
          }
        }
      }

      if (isAllowed(key)) {
        feature.setAttrWithMinzoom(key, value, minZoom);

        if (fontRegistry.getScripts().contains(script)) {
          String encodedValue = TextEngine.encodeRegisteredScripts(value);
          if (!encodedValue.equals(value)) {
            feature.setAttrWithMinzoom("pgf:" + key, encodedValue, minZoom);
          }
        }
      }

    }

    // Backfill name:zh to name:zh-Hant and name:zh-Hans if those are not available
    if (sf.hasTag("name:zh")) {
      if (!sf.hasTag("name:zh-Hant")) {
        feature.setAttrWithMinzoom("name:zh-Hant", sf.getTag("name:zh"), minZoom);
      }
      if (!sf.hasTag("name:zh-Hans")) {
        feature.setAttrWithMinzoom("name:zh-Hans", sf.getTag("name:zh"), minZoom);
      }
    }
    return feature;
  }

  public static FeatureCollector.Feature setOsmRefs(FeatureCollector.Feature feature, SourceFeature sf,
    int minZoom) {
    for (Map.Entry<String, Object> tag : sf.tags().entrySet()) {
      var key = tag.getKey();
      // Short codes (CA not Calif.)
      // (nvkelso 20230801) 58% of state/province nodes have ref values
      if ((key.equals("ref") || key.startsWith("ref:")) && sf.getString(key).length() < 5) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(sf.getString(key), pos);
        if (sf.getString(key).length() != pos.getIndex()) {
          feature.setAttrWithMinzoom(key, sf.getTag(key), minZoom);
        }
      }
    }
    return feature;
  }
}
