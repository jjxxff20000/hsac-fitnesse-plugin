package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Rule;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;
import nl.hsac.fitnesse.util.IncrementUtl;

/**
 * Generate increment positive integer.
 * 
 * usage: !incrementInt [(initValue)]
 * 
 * @author Bob
 *
 */
public class IncrementInt extends SymbolBase implements Rule, Translation {
//	如何实现静态全局变量来控制自增id输出??? 使用单例模式的工具类是否可行?
	private static final IncrementUtl INCREMENT_UTIL = IncrementUtl.getInstance();
	private static final String START_INT = "startInt";

	public IncrementInt() {
		super("incrementInt");
		wikiMatcher(new Matcher().string("!incrementInt"));
		wikiRule(this);
		htmlTranslation(this);
	}
	public Maybe<Symbol> parse(Symbol current, Parser parser) {
        return storeParenthesisContent(current, parser, START_INT);
    }

    public String toTarget(Translator translator, Symbol symbol) {
		String param = symbol.getProperty(START_INT, null);
        if (param == null) {
            return Integer.toString(INCREMENT_UTIL.incrementInt());
        }else{
			int initValue = parseInt(param);
			INCREMENT_UTIL.setCurrent(--initValue);
			return Integer.toString(INCREMENT_UTIL.incrementInt());
		}
    	
    }
}
