/**
 * Player.java
 * 
 * @Author
 *   Yuki Kawata
 */

package wiz.project.jan;

import java.util.UUID;



/**
 * プレイヤー
 */
public final class Player implements Cloneable {
    
    /**
     * コンストラクタ
     */
    public Player() {
        _playerID = UUID.randomUUID();
    }
    
    /**
     * コンストラクタ
     * 
     * @param name 名前。
     */
    public Player(final String name) {
        this();
        setName(name);
    }
    
    /**
     * コンストラクタ
     * 
     * @param name 名前。
     * @param wind 風。
     */
    public Player(final String name, final Wind wind) {
        this(name);
        setWind(wind);
    }
    
    /**
     * コンストラクタ
     * 
     * @param name 名前。
     * @param wind 風。
     * @param hand 手牌。
     */
    public Player(final String name, final Wind wind, final Hand hand) {
        this(name, wind);
        setHand(hand);
    }
    
    /**
     * コピーコンストラクタ
     * 
     * @param source 複製元。
     */
    public Player(final Player source) {
        if (source != null) {
            _playerID = source._playerID;
            _wind = source._wind;
            _hand = source._hand.clone();
        }
        else {
            _playerID = UUID.randomUUID();
        }
    }
    
    
    
    /**
     * 自分自身を複製 (ディープコピー)
     * 
     * @return 複製結果。
     */
    @Override
    public Player clone() {
        return new Player(this);
    }
    
    /**
     * 等価なオブジェクトか
     * 
     * @param target 比較対象。
     * @return 比較結果。
     */
    @Override
    public boolean equals(final Object target) {
        if (this == target) {
            return true;
        }
        if (target == null) {
            return false;
        }
        if (!(target instanceof Player)) {
            return false;
        }
        
        final Player targetPlayer = (Player)target;
        return _playerID.equals(targetPlayer._playerID);
    }
    
    /**
     * 手牌を取得
     * 
     * @return 手牌。
     */
    public Hand getHand() {
        return _hand.clone();
    }
    
    /**
     * IDを取得
     * 
     * @return ID。
     */
    public UUID getID() {
        return _playerID;
    }
    
    /**
     * 名前を取得
     * 
     * @return 名前。
     */
    public String getName() {
        return _name;
    }
    
    /**
     * 風を取得
     * 
     * @return 風。
     */
    public Wind getWind() {
        return _wind;
    }
    
    /**
     * ハッシュコードを取得
     * 
     * @return ハッシュコード。
     */
    @Override
    public int hashCode() {
        return _playerID.hashCode();
    }
    
    /**
     * 手牌を設定
     * 
     * @param hand 手牌。
     */
    public void setHand(final Hand hand) {
        if (hand != null) {
            _hand = hand.clone();
        }
        else {
            _hand = new Hand();
        }
    }
    
    /**
     * 名前を設定
     * 
     * @param name 名前。
     */
    public void setName(final String name) {
        if (name != null) {
            _name = name;
        }
        else {
            _name = "";
        }
    }
    
    /**
     * 風を設定
     * 
     * @param wind 風。
     */
    public void setWind(final Wind wind) {
        if (wind != null) {
            _wind = wind;
        }
        else {
            _wind = Wind.TON;
        }
    }
    
    /**
     * 文字列に変換
     * 
     * @return 変換結果。
     */
    @Override
    public String toString() {
        return _name + " [" + _wind + "]";
    }
    
    
    
    /**
     * ID
     */
    private final UUID _playerID;
    
    /**
     * 名前
     */
    private String _name = "";
    
    /**
     * 風
     */
    private Wind _wind = Wind.TON;
    
    /**
     * 手牌
     */
    private Hand _hand = new Hand();
    
}

