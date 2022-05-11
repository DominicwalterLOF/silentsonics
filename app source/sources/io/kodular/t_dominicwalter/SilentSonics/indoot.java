package io.kodular.t_dominicwalter.SilentSonics;

import androidx.fragment.app.FragmentTransaction;
import com.KIO4_Move.KIO4_Move;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AccelerometerSensor;
import com.google.appinventor.components.runtime.Canvas;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.KodularLottie;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.MagneticFieldSensor;
import com.google.appinventor.components.runtime.MakeroidCardView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.OrientationSensor;
import com.google.appinventor.components.runtime.ProgressBar;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import edu.mit.appinventor.ble.BluetoothLE;
import gnu.expr.GenericProc;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.expt;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.slf4j.Marker;

/* compiled from: indoot.yail */
public class indoot extends Form implements Runnable {
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final DFloNum Lit10 = DFloNum.make(0.1d);
    static final IntNum Lit100 = IntNum.make(-1050);
    static final IntNum Lit101 = IntNum.make(-2);
    static final FString Lit102;
    static final FString Lit103;
    static final SimpleSymbol Lit104;
    static final IntNum Lit105;
    static final SimpleSymbol Lit106;
    static final IntNum Lit107 = IntNum.make(20);
    static final SimpleSymbol Lit108;
    static final FString Lit109;
    static final SimpleSymbol Lit11;
    static final FString Lit110;
    static final SimpleSymbol Lit111;
    static final FString Lit112;
    static final FString Lit113;
    static final SimpleSymbol Lit114;
    static final IntNum Lit115;
    static final SimpleSymbol Lit116;
    static final SimpleSymbol Lit117;
    static final SimpleSymbol Lit118;
    static final SimpleSymbol Lit119;
    static final IntNum Lit12 = IntNum.make(0);
    static final IntNum Lit120 = IntNum.make(50);
    static final FString Lit121;
    static final FString Lit122;
    static final SimpleSymbol Lit123;
    static final IntNum Lit124;
    static final SimpleSymbol Lit125;
    static final SimpleSymbol Lit126;
    static final SimpleSymbol Lit127;
    static final IntNum Lit128;
    static final FString Lit129;
    static final SimpleSymbol Lit13;
    static final FString Lit130;
    static final SimpleSymbol Lit131;
    static final FString Lit132;
    static final FString Lit133;
    static final SimpleSymbol Lit134;
    static final SimpleSymbol Lit135;
    static final FString Lit136;
    static final FString Lit137;
    static final SimpleSymbol Lit138;
    static final FString Lit139;
    static final IntNum Lit14 = IntNum.make(1000);
    static final FString Lit140;
    static final SimpleSymbol Lit141;
    static final FString Lit142;
    static final FString Lit143;
    static final SimpleSymbol Lit144;
    static final FString Lit145;
    static final FString Lit146;
    static final SimpleSymbol Lit147;
    static final IntNum Lit148;
    static final FString Lit149;
    static final PairWithPosition Lit15 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33148), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33141), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33134), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33126);
    static final FString Lit150;
    static final SimpleSymbol Lit151;
    static final IntNum Lit152;
    static final FString Lit153;
    static final FString Lit154;
    static final SimpleSymbol Lit155;
    static final SimpleSymbol Lit156;
    static final IntNum Lit157 = IntNum.make(3);
    static final SimpleSymbol Lit158;
    static final FString Lit159;
    static final PairWithPosition Lit16 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33300), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33293), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33286), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33278);
    static final FString Lit160;
    static final IntNum Lit161;
    static final FString Lit162;
    static final FString Lit163;
    static final SimpleSymbol Lit164;
    static final IntNum Lit165;
    static final FString Lit166;
    static final FString Lit167;
    static final SimpleSymbol Lit168;
    static final FString Lit169;
    static final IntNum Lit17 = IntNum.make(1);
    static final FString Lit170;
    static final SimpleSymbol Lit171;
    static final FString Lit172;
    static final FString Lit173;
    static final SimpleSymbol Lit174;
    static final FString Lit175;
    static final FString Lit176;
    static final SimpleSymbol Lit177;
    static final SimpleSymbol Lit178;
    static final FString Lit179;
    static final SimpleSymbol Lit18;
    static final FString Lit180;
    static final SimpleSymbol Lit181;
    static final FString Lit182;
    static final FString Lit183;
    static final SimpleSymbol Lit184;
    static final FString Lit185;
    static final FString Lit186;
    static final SimpleSymbol Lit187;
    static final FString Lit188;
    static final FString Lit189;
    static final IntNum Lit19 = IntNum.make(2);
    static final SimpleSymbol Lit190;
    static final FString Lit191;
    static final FString Lit192;
    static final SimpleSymbol Lit193;
    static final FString Lit194;
    static final SimpleSymbol Lit195;
    static final SimpleSymbol Lit196;
    static final IntNum Lit197 = IntNum.make(6);
    static final PairWithPosition Lit198 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098020), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098012);
    static final PairWithPosition Lit199 = PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098045);
    static final SimpleSymbol Lit2;
    static final PairWithPosition Lit20 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33400), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33392);
    static final IntNum Lit200 = IntNum.make(-6);
    static final PairWithPosition Lit201 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098077), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098069);
    static final PairWithPosition Lit202;
    static final PairWithPosition Lit203 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098337), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098329);
    static final PairWithPosition Lit204 = PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098362);
    static final PairWithPosition Lit205;
    static final SimpleSymbol Lit206;
    static final SimpleSymbol Lit207;
    static final FString Lit208;
    static final FString Lit209;
    static final IntNum Lit21 = IntNum.make(10);
    static final SimpleSymbol Lit210;
    static final SimpleSymbol Lit211;
    static final SimpleSymbol Lit212;
    static final SimpleSymbol Lit213;
    static final SimpleSymbol Lit214;
    static final SimpleSymbol Lit215;
    static final SimpleSymbol Lit216;
    static final SimpleSymbol Lit217;
    static final SimpleSymbol Lit218;
    static final SimpleSymbol Lit219;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit220;
    static final SimpleSymbol Lit221;
    static final SimpleSymbol Lit222;
    static final SimpleSymbol Lit223;
    static final SimpleSymbol Lit23;
    static final PairWithPosition Lit24 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33633), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33625);
    static final PairWithPosition Lit25 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33754), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33746);
    static final PairWithPosition Lit26 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit89, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33809), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33802), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33795), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33787);
    static final SimpleSymbol Lit27;
    static final IntNum Lit28 = IntNum.make(100);
    static final PairWithPosition Lit29 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34018), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34010);
    static final SimpleSymbol Lit3;
    static final PairWithPosition Lit30 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34139), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34131);
    static final PairWithPosition Lit31 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34186), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34179), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34172), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34164);
    static final PairWithPosition Lit32 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33148), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33141), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33134), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33126);
    static final PairWithPosition Lit33 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33300), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33293), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33286), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33278);
    static final PairWithPosition Lit34 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33400), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33392);
    static final PairWithPosition Lit35 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33633), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33625);
    static final PairWithPosition Lit36 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33754), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33746);
    static final PairWithPosition Lit37 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit89, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33809), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33802), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33795), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 33787);
    static final PairWithPosition Lit38 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34018), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34010);
    static final PairWithPosition Lit39 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34139), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34131);
    static final SimpleSymbol Lit4;
    static final PairWithPosition Lit40 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34186), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34179), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34172), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 34164);
    static final SimpleSymbol Lit41;
    static final IntNum Lit42 = IntNum.make(70);
    static final IntNum Lit43 = IntNum.make(200);
    static final PairWithPosition Lit44 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37022), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37015), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37008), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37000);
    static final PairWithPosition Lit45 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37197), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37189);
    static final PairWithPosition Lit46 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37318), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37310);
    static final PairWithPosition Lit47 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37365), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37358), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37351), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37343);
    static final PairWithPosition Lit48 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37022), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37015), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37008), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37000);
    static final PairWithPosition Lit49 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37197), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37189);
    static final SimpleSymbol Lit5;
    static final PairWithPosition Lit50 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37318), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37310);
    static final PairWithPosition Lit51 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37365), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37358), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37351), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 37343);
    static final IntNum Lit52 = IntNum.make(-1);
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final IntNum Lit55 = IntNum.make(5);
    static final PairWithPosition Lit56 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit89, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41236), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41229), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41222), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41214);
    static final DFloNum Lit57 = DFloNum.make(0.1d);
    static final PairWithPosition Lit58 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, PairWithPosition.make(Lit89, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41236), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41229), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41222), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 41214);
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final PairWithPosition Lit62 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45314), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45306);
    static final PairWithPosition Lit63 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45339), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45331);
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final PairWithPosition Lit66 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45494), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45486);
    static final PairWithPosition Lit67 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45519), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45511);
    static final PairWithPosition Lit68 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45546), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45538);
    static final PairWithPosition Lit69 = PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45562);
    static final IntNum Lit7 = IntNum.make(-16724788);
    static final PairWithPosition Lit70 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45314), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45306);
    static final PairWithPosition Lit71 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45339), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45331);
    static final PairWithPosition Lit72 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45494), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45486);
    static final PairWithPosition Lit73 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45519), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45511);
    static final PairWithPosition Lit74 = PairWithPosition.make(Lit8, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45546), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45538);
    static final PairWithPosition Lit75 = PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 45562);
    static final SimpleSymbol Lit76;
    static final IntNum Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final IntNum Lit82;
    static final SimpleSymbol Lit83;
    static final IntNum Lit84;
    static final SimpleSymbol Lit85;
    static final IntNum Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit90;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final PairWithPosition Lit95;
    static final SimpleSymbol Lit96;
    static final SimpleSymbol Lit97;
    static final FString Lit98;
    static final SimpleSymbol Lit99;
    public static indoot indoot;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn41 = null;
    static final ModuleMethod lambda$Fn42 = null;
    static final ModuleMethod lambda$Fn43 = null;
    static final ModuleMethod lambda$Fn44 = null;
    static final ModuleMethod lambda$Fn45 = null;
    static final ModuleMethod lambda$Fn46 = null;
    static final ModuleMethod lambda$Fn47 = null;
    static final ModuleMethod lambda$Fn48 = null;
    static final ModuleMethod lambda$Fn49 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn50 = null;
    static final ModuleMethod lambda$Fn51 = null;
    static final ModuleMethod lambda$Fn52 = null;
    static final ModuleMethod lambda$Fn53 = null;
    static final ModuleMethod lambda$Fn54 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public AccelerometerSensor Accelerometer_Sensor1;
    public BluetoothLE BluetoothLE1;
    public Canvas Canvas1;
    public MakeroidCardView Card_View1;
    public MakeroidCardView Card_View2;
    public MakeroidCardView Card_View3;
    public MakeroidCardView Card_View4;
    public ProgressBar Custom_Progress1;
    public ProgressBar Custom_Progress1_copy;
    public ProgressBar Custom_Progress1_copy1;
    public ProgressBar Custom_Progress1_copy2;
    public ProgressBar Custom_Progress1_copy3;
    public HorizontalArrangement Horizontal_Arrangement1;
    public KIO4_Move KIO4_Move1;
    public Label Label1;
    public Label Label2;
    public Label Label3;
    public KodularLottie Lottie1;
    public MagneticFieldSensor Magnetic_Field_Sensor1;
    public Notifier Notifier1;
    public OrientationSensor Orientation_Sensor1;
    public final ModuleMethod Orientation_Sensor1$OrientationChanged;
    public VerticalArrangement Vertical_Arrangement1;
    public VerticalArrangement Vertical_Arrangement2;
    public VerticalArrangement Vertical_Arrangement3;
    public VerticalArrangement Vertical_Arrangement4;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod indoot$Initialize;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    static {
        SimpleSymbol simpleSymbol;
        SimpleSymbol simpleSymbol2;
        SimpleSymbol simpleSymbol3;
        SimpleSymbol simpleSymbol4;
        SimpleSymbol simpleSymbol5;
        SimpleSymbol simpleSymbol6;
        SimpleSymbol simpleSymbol7;
        SimpleSymbol simpleSymbol8;
        SimpleSymbol simpleSymbol9;
        SimpleSymbol simpleSymbol10;
        SimpleSymbol simpleSymbol11;
        SimpleSymbol simpleSymbol12;
        SimpleSymbol simpleSymbol13;
        SimpleSymbol simpleSymbol14;
        FString fString;
        FString fString2;
        SimpleSymbol simpleSymbol15;
        SimpleSymbol simpleSymbol16;
        SimpleSymbol simpleSymbol17;
        SimpleSymbol simpleSymbol18;
        SimpleSymbol simpleSymbol19;
        SimpleSymbol simpleSymbol20;
        FString fString3;
        SimpleSymbol simpleSymbol21;
        FString fString4;
        FString fString5;
        SimpleSymbol simpleSymbol22;
        FString fString6;
        FString fString7;
        SimpleSymbol simpleSymbol23;
        FString fString8;
        FString fString9;
        SimpleSymbol simpleSymbol24;
        FString fString10;
        FString fString11;
        SimpleSymbol simpleSymbol25;
        FString fString12;
        FString fString13;
        SimpleSymbol simpleSymbol26;
        SimpleSymbol simpleSymbol27;
        FString fString14;
        FString fString15;
        SimpleSymbol simpleSymbol28;
        FString fString16;
        FString fString17;
        SimpleSymbol simpleSymbol29;
        FString fString18;
        FString fString19;
        SimpleSymbol simpleSymbol30;
        FString fString20;
        FString fString21;
        SimpleSymbol simpleSymbol31;
        FString fString22;
        FString fString23;
        FString fString24;
        FString fString25;
        SimpleSymbol simpleSymbol32;
        SimpleSymbol simpleSymbol33;
        SimpleSymbol simpleSymbol34;
        FString fString26;
        FString fString27;
        SimpleSymbol simpleSymbol35;
        FString fString28;
        FString fString29;
        SimpleSymbol simpleSymbol36;
        FString fString30;
        FString fString31;
        SimpleSymbol simpleSymbol37;
        FString fString32;
        FString fString33;
        SimpleSymbol simpleSymbol38;
        FString fString34;
        FString fString35;
        SimpleSymbol simpleSymbol39;
        FString fString36;
        FString fString37;
        SimpleSymbol simpleSymbol40;
        SimpleSymbol simpleSymbol41;
        FString fString38;
        FString fString39;
        SimpleSymbol simpleSymbol42;
        FString fString40;
        FString fString41;
        SimpleSymbol simpleSymbol43;
        SimpleSymbol simpleSymbol44;
        SimpleSymbol simpleSymbol45;
        SimpleSymbol simpleSymbol46;
        FString fString42;
        FString fString43;
        SimpleSymbol simpleSymbol47;
        SimpleSymbol simpleSymbol48;
        SimpleSymbol simpleSymbol49;
        SimpleSymbol simpleSymbol50;
        SimpleSymbol simpleSymbol51;
        FString fString44;
        FString fString45;
        SimpleSymbol simpleSymbol52;
        FString fString46;
        FString fString47;
        SimpleSymbol simpleSymbol53;
        SimpleSymbol simpleSymbol54;
        SimpleSymbol simpleSymbol55;
        FString fString48;
        FString fString49;
        SimpleSymbol simpleSymbol56;
        FString fString50;
        SimpleSymbol simpleSymbol57;
        SimpleSymbol simpleSymbol58;
        SimpleSymbol simpleSymbol59;
        SimpleSymbol simpleSymbol60;
        SimpleSymbol simpleSymbol61;
        SimpleSymbol simpleSymbol62;
        SimpleSymbol simpleSymbol63;
        SimpleSymbol simpleSymbol64;
        SimpleSymbol simpleSymbol65;
        SimpleSymbol simpleSymbol66;
        SimpleSymbol simpleSymbol67;
        SimpleSymbol simpleSymbol68;
        SimpleSymbol simpleSymbol69;
        SimpleSymbol simpleSymbol70;
        SimpleSymbol simpleSymbol71;
        SimpleSymbol simpleSymbol72;
        SimpleSymbol simpleSymbol73;
        SimpleSymbol simpleSymbol74;
        SimpleSymbol simpleSymbol75;
        SimpleSymbol simpleSymbol76;
        SimpleSymbol simpleSymbol77;
        SimpleSymbol simpleSymbol78;
        SimpleSymbol simpleSymbol79;
        SimpleSymbol simpleSymbol80;
        SimpleSymbol simpleSymbol81;
        SimpleSymbol simpleSymbol82;
        SimpleSymbol simpleSymbol83;
        SimpleSymbol simpleSymbol84;
        SimpleSymbol simpleSymbol85;
        SimpleSymbol simpleSymbol86;
        SimpleSymbol simpleSymbol87;
        SimpleSymbol simpleSymbol88;
        SimpleSymbol simpleSymbol89;
        SimpleSymbol simpleSymbol90;
        SimpleSymbol simpleSymbol91;
        SimpleSymbol simpleSymbol92;
        SimpleSymbol simpleSymbol93;
        SimpleSymbol simpleSymbol94;
        SimpleSymbol simpleSymbol95;
        new SimpleSymbol("lookup-handler");
        Lit223 = (SimpleSymbol) simpleSymbol.readResolve();
        new SimpleSymbol("dispatchGenericEvent");
        Lit222 = (SimpleSymbol) simpleSymbol2.readResolve();
        new SimpleSymbol("dispatchEvent");
        Lit221 = (SimpleSymbol) simpleSymbol3.readResolve();
        new SimpleSymbol("send-error");
        Lit220 = (SimpleSymbol) simpleSymbol4.readResolve();
        new SimpleSymbol("add-to-form-do-after-creation");
        Lit219 = (SimpleSymbol) simpleSymbol5.readResolve();
        new SimpleSymbol("add-to-global-vars");
        Lit218 = (SimpleSymbol) simpleSymbol6.readResolve();
        new SimpleSymbol("add-to-components");
        Lit217 = (SimpleSymbol) simpleSymbol7.readResolve();
        new SimpleSymbol("add-to-events");
        Lit216 = (SimpleSymbol) simpleSymbol8.readResolve();
        new SimpleSymbol("add-to-global-var-environment");
        Lit215 = (SimpleSymbol) simpleSymbol9.readResolve();
        new SimpleSymbol("is-bound-in-form-environment");
        Lit214 = (SimpleSymbol) simpleSymbol10.readResolve();
        new SimpleSymbol("lookup-in-form-environment");
        Lit213 = (SimpleSymbol) simpleSymbol11.readResolve();
        new SimpleSymbol("add-to-form-environment");
        Lit212 = (SimpleSymbol) simpleSymbol12.readResolve();
        new SimpleSymbol("android-log-form");
        Lit211 = (SimpleSymbol) simpleSymbol13.readResolve();
        new SimpleSymbol("get-simple-name");
        Lit210 = (SimpleSymbol) simpleSymbol14.readResolve();
        new FString("com.google.appinventor.components.runtime.Notifier");
        Lit209 = fString;
        new FString("com.google.appinventor.components.runtime.Notifier");
        Lit208 = fString2;
        new SimpleSymbol("OrientationChanged");
        Lit207 = (SimpleSymbol) simpleSymbol15.readResolve();
        new SimpleSymbol("Orientation_Sensor1$OrientationChanged");
        Lit206 = (SimpleSymbol) simpleSymbol16.readResolve();
        new SimpleSymbol("number");
        SimpleSymbol simpleSymbol96 = (SimpleSymbol) simpleSymbol17.readResolve();
        Lit8 = simpleSymbol96;
        Lit205 = PairWithPosition.make(simpleSymbol96, PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098393), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098385);
        new SimpleSymbol("component");
        Lit202 = PairWithPosition.make((SimpleSymbol) simpleSymbol18.readResolve(), PairWithPosition.make(Lit8, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098104), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 1098093);
        new SimpleSymbol("$azimuth");
        Lit196 = (SimpleSymbol) simpleSymbol19.readResolve();
        new SimpleSymbol("Rotate");
        Lit195 = (SimpleSymbol) simpleSymbol20.readResolve();
        new FString("com.google.appinventor.components.runtime.OrientationSensor");
        Lit194 = fString3;
        new SimpleSymbol("Orientation_Sensor1");
        Lit193 = (SimpleSymbol) simpleSymbol21.readResolve();
        new FString("com.google.appinventor.components.runtime.OrientationSensor");
        Lit192 = fString4;
        new FString("com.KIO4_Move.KIO4_Move");
        Lit191 = fString5;
        new SimpleSymbol("KIO4_Move1");
        Lit190 = (SimpleSymbol) simpleSymbol22.readResolve();
        new FString("com.KIO4_Move.KIO4_Move");
        Lit189 = fString6;
        new FString("com.google.appinventor.components.runtime.AccelerometerSensor");
        Lit188 = fString7;
        new SimpleSymbol("Accelerometer_Sensor1");
        Lit187 = (SimpleSymbol) simpleSymbol23.readResolve();
        new FString("com.google.appinventor.components.runtime.AccelerometerSensor");
        Lit186 = fString8;
        new FString("com.google.appinventor.components.runtime.MagneticFieldSensor");
        Lit185 = fString9;
        new SimpleSymbol("Magnetic_Field_Sensor1");
        Lit184 = (SimpleSymbol) simpleSymbol24.readResolve();
        new FString("com.google.appinventor.components.runtime.MagneticFieldSensor");
        Lit183 = fString10;
        new FString("edu.mit.appinventor.ble.BluetoothLE");
        Lit182 = fString11;
        new SimpleSymbol("BluetoothLE1");
        Lit181 = (SimpleSymbol) simpleSymbol25.readResolve();
        new FString("edu.mit.appinventor.ble.BluetoothLE");
        Lit180 = fString12;
        new FString("com.google.appinventor.components.runtime.KodularLottie");
        Lit179 = fString13;
        new SimpleSymbol("Source");
        Lit178 = (SimpleSymbol) simpleSymbol26.readResolve();
        new SimpleSymbol("Lottie1");
        Lit177 = (SimpleSymbol) simpleSymbol27.readResolve();
        new FString("com.google.appinventor.components.runtime.KodularLottie");
        Lit176 = fString14;
        new FString("com.google.appinventor.components.runtime.Label");
        Lit175 = fString15;
        new SimpleSymbol("Label1");
        Lit174 = (SimpleSymbol) simpleSymbol28.readResolve();
        new FString("com.google.appinventor.components.runtime.Label");
        Lit173 = fString16;
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit172 = fString17;
        new SimpleSymbol("Card_View1");
        Lit171 = (SimpleSymbol) simpleSymbol29.readResolve();
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit170 = fString18;
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit169 = fString19;
        new SimpleSymbol("Vertical_Arrangement4");
        Lit168 = (SimpleSymbol) simpleSymbol30.readResolve();
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit167 = fString20;
        new FString("com.google.appinventor.components.runtime.Label");
        Lit166 = fString21;
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit165 = IntNum.make(iArr);
        new SimpleSymbol("Label3");
        Lit164 = (SimpleSymbol) simpleSymbol31.readResolve();
        new FString("com.google.appinventor.components.runtime.Label");
        Lit163 = fString22;
        new FString("com.google.appinventor.components.runtime.Canvas");
        Lit162 = fString23;
        int[] iArr2 = new int[2];
        iArr2[0] = -14344902;
        Lit161 = IntNum.make(iArr2);
        new FString("com.google.appinventor.components.runtime.Canvas");
        Lit160 = fString24;
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit159 = fString25;
        new SimpleSymbol("AlignVertical");
        Lit158 = (SimpleSymbol) simpleSymbol32.readResolve();
        new SimpleSymbol("AlignHorizontal");
        Lit156 = (SimpleSymbol) simpleSymbol33.readResolve();
        new SimpleSymbol("Vertical_Arrangement2");
        Lit155 = (SimpleSymbol) simpleSymbol34.readResolve();
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit154 = fString26;
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit153 = fString27;
        int[] iArr3 = new int[2];
        iArr3[0] = -14344902;
        Lit152 = IntNum.make(iArr3);
        new SimpleSymbol("Vertical_Arrangement3");
        Lit151 = (SimpleSymbol) simpleSymbol35.readResolve();
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit150 = fString28;
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit149 = fString29;
        int[] iArr4 = new int[2];
        iArr4[0] = -14344902;
        Lit148 = IntNum.make(iArr4);
        new SimpleSymbol("Card_View4");
        Lit147 = (SimpleSymbol) simpleSymbol36.readResolve();
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit146 = fString30;
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit145 = fString31;
        new SimpleSymbol("Custom_Progress1");
        Lit144 = (SimpleSymbol) simpleSymbol37.readResolve();
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit143 = fString32;
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit142 = fString33;
        new SimpleSymbol("Custom_Progress1_copy");
        Lit141 = (SimpleSymbol) simpleSymbol38.readResolve();
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit140 = fString34;
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit139 = fString35;
        new SimpleSymbol("Custom_Progress1_copy3");
        Lit138 = (SimpleSymbol) simpleSymbol39.readResolve();
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit137 = fString36;
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit136 = fString37;
        new SimpleSymbol("Visible");
        Lit135 = (SimpleSymbol) simpleSymbol40.readResolve();
        new SimpleSymbol("Custom_Progress1_copy2");
        Lit134 = (SimpleSymbol) simpleSymbol41.readResolve();
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit133 = fString38;
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit132 = fString39;
        new SimpleSymbol("Custom_Progress1_copy1");
        Lit131 = (SimpleSymbol) simpleSymbol42.readResolve();
        new FString("com.google.appinventor.components.runtime.ProgressBar");
        Lit130 = fString40;
        new FString("com.google.appinventor.components.runtime.Label");
        Lit129 = fString41;
        int[] iArr5 = new int[2];
        iArr5[0] = -14344902;
        Lit128 = IntNum.make(iArr5);
        new SimpleSymbol("TextColor");
        Lit127 = (SimpleSymbol) simpleSymbol43.readResolve();
        new SimpleSymbol("TextAlignment");
        Lit126 = (SimpleSymbol) simpleSymbol44.readResolve();
        new SimpleSymbol("Text");
        Lit125 = (SimpleSymbol) simpleSymbol45.readResolve();
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit124 = IntNum.make(iArr6);
        new SimpleSymbol("Label2");
        Lit123 = (SimpleSymbol) simpleSymbol46.readResolve();
        new FString("com.google.appinventor.components.runtime.Label");
        Lit122 = fString42;
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit121 = fString43;
        new SimpleSymbol("ContentPaddingTop");
        Lit119 = (SimpleSymbol) simpleSymbol47.readResolve();
        new SimpleSymbol("ContentPaddingRight");
        Lit118 = (SimpleSymbol) simpleSymbol48.readResolve();
        new SimpleSymbol("ContentPaddingLeft");
        Lit117 = (SimpleSymbol) simpleSymbol49.readResolve();
        new SimpleSymbol("ContentPaddingBottom");
        Lit116 = (SimpleSymbol) simpleSymbol50.readResolve();
        int[] iArr7 = new int[2];
        iArr7[0] = -14015152;
        Lit115 = IntNum.make(iArr7);
        new SimpleSymbol("Card_View3");
        Lit114 = (SimpleSymbol) simpleSymbol51.readResolve();
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit113 = fString44;
        new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit112 = fString45;
        new SimpleSymbol("Horizontal_Arrangement1");
        Lit111 = (SimpleSymbol) simpleSymbol52.readResolve();
        new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit110 = fString46;
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit109 = fString47;
        new SimpleSymbol("Elevation");
        Lit108 = (SimpleSymbol) simpleSymbol53.readResolve();
        new SimpleSymbol("CornerRadius");
        Lit106 = (SimpleSymbol) simpleSymbol54.readResolve();
        int[] iArr8 = new int[2];
        iArr8[0] = -30332591;
        Lit105 = IntNum.make(iArr8);
        new SimpleSymbol("Card_View2");
        Lit104 = (SimpleSymbol) simpleSymbol55.readResolve();
        new FString("com.google.appinventor.components.runtime.MakeroidCardView");
        Lit103 = fString48;
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit102 = fString49;
        new SimpleSymbol("Vertical_Arrangement1");
        Lit99 = (SimpleSymbol) simpleSymbol56.readResolve();
        new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit98 = fString50;
        new SimpleSymbol("Initialize");
        Lit97 = (SimpleSymbol) simpleSymbol57.readResolve();
        new SimpleSymbol("indoot$Initialize");
        Lit96 = (SimpleSymbol) simpleSymbol58.readResolve();
        new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT);
        SimpleSymbol simpleSymbol97 = (SimpleSymbol) simpleSymbol59.readResolve();
        Lit79 = simpleSymbol97;
        Lit95 = PairWithPosition.make(simpleSymbol97, PairWithPosition.make(Lit79, PairWithPosition.make(Lit79, LList.Empty, "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 114922), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 114917), "/tmp/1652269943678_0.9961217481179881-0/youngandroidproject/../src/io/kodular/t_dominicwalter/SilentSonics/indoot.yail", 114911);
        new SimpleSymbol("ShowMessageDialog");
        Lit94 = (SimpleSymbol) simpleSymbol60.readResolve();
        new SimpleSymbol("Notifier1");
        Lit93 = (SimpleSymbol) simpleSymbol61.readResolve();
        new SimpleSymbol("TitleVisible");
        Lit92 = (SimpleSymbol) simpleSymbol62.readResolve();
        new SimpleSymbol("Title");
        Lit91 = (SimpleSymbol) simpleSymbol63.readResolve();
        new SimpleSymbol("Theme");
        Lit90 = (SimpleSymbol) simpleSymbol64.readResolve();
        new SimpleSymbol("boolean");
        Lit89 = (SimpleSymbol) simpleSymbol65.readResolve();
        new SimpleSymbol("SplashEnabled");
        Lit88 = (SimpleSymbol) simpleSymbol66.readResolve();
        new SimpleSymbol("ReceiveSharedText");
        Lit87 = (SimpleSymbol) simpleSymbol67.readResolve();
        int[] iArr9 = new int[2];
        iArr9[0] = -14344902;
        Lit86 = IntNum.make(iArr9);
        new SimpleSymbol("PrimaryColorDark");
        Lit85 = (SimpleSymbol) simpleSymbol68.readResolve();
        int[] iArr10 = new int[2];
        iArr10[0] = -14015152;
        Lit84 = IntNum.make(iArr10);
        new SimpleSymbol("PrimaryColor");
        Lit83 = (SimpleSymbol) simpleSymbol69.readResolve();
        int[] iArr11 = new int[2];
        iArr11[0] = -14015152;
        Lit82 = IntNum.make(iArr11);
        new SimpleSymbol("BackgroundColor");
        Lit81 = (SimpleSymbol) simpleSymbol70.readResolve();
        new SimpleSymbol("AppName");
        Lit80 = (SimpleSymbol) simpleSymbol71.readResolve();
        new SimpleSymbol("AppId");
        Lit78 = (SimpleSymbol) simpleSymbol72.readResolve();
        int[] iArr12 = new int[2];
        iArr12[0] = -35072;
        Lit77 = IntNum.make(iArr12);
        new SimpleSymbol("AccentColor");
        Lit76 = (SimpleSymbol) simpleSymbol73.readResolve();
        new SimpleSymbol("$y2");
        Lit65 = (SimpleSymbol) simpleSymbol74.readResolve();
        new SimpleSymbol("$y1");
        Lit64 = (SimpleSymbol) simpleSymbol75.readResolve();
        new SimpleSymbol("$x2");
        Lit61 = (SimpleSymbol) simpleSymbol76.readResolve();
        new SimpleSymbol("$x1");
        Lit60 = (SimpleSymbol) simpleSymbol77.readResolve();
        new SimpleSymbol("p$dis");
        Lit59 = (SimpleSymbol) simpleSymbol78.readResolve();
        new SimpleSymbol("$y");
        Lit54 = (SimpleSymbol) simpleSymbol79.readResolve();
        new SimpleSymbol("$x");
        Lit53 = (SimpleSymbol) simpleSymbol80.readResolve();
        new SimpleSymbol("p$procedure3");
        Lit41 = (SimpleSymbol) simpleSymbol81.readResolve();
        new SimpleSymbol("p$procedure2");
        Lit27 = (SimpleSymbol) simpleSymbol82.readResolve();
        new SimpleSymbol("Width");
        Lit23 = (SimpleSymbol) simpleSymbol83.readResolve();
        new SimpleSymbol("DrawCircle");
        Lit22 = (SimpleSymbol) simpleSymbol84.readResolve();
        new SimpleSymbol("Height");
        Lit18 = (SimpleSymbol) simpleSymbol85.readResolve();
        new SimpleSymbol("$number");
        Lit13 = (SimpleSymbol) simpleSymbol86.readResolve();
        new SimpleSymbol("DrawLine");
        Lit11 = (SimpleSymbol) simpleSymbol87.readResolve();
        new SimpleSymbol("LineWidth");
        Lit9 = (SimpleSymbol) simpleSymbol88.readResolve();
        new SimpleSymbol("PaintColor");
        Lit6 = (SimpleSymbol) simpleSymbol89.readResolve();
        new SimpleSymbol("Clear");
        Lit5 = (SimpleSymbol) simpleSymbol90.readResolve();
        new SimpleSymbol("Canvas1");
        Lit4 = (SimpleSymbol) simpleSymbol91.readResolve();
        new SimpleSymbol("p$procedure");
        Lit3 = (SimpleSymbol) simpleSymbol92.readResolve();
        new SimpleSymbol("*the-null-value*");
        Lit2 = (SimpleSymbol) simpleSymbol93.readResolve();
        new SimpleSymbol("getMessage");
        Lit1 = (SimpleSymbol) simpleSymbol94.readResolve();
        new SimpleSymbol("indoot");
        Lit0 = (SimpleSymbol) simpleSymbol95.readResolve();
    }

    public indoot() {
        ModuleMethod moduleMethod;
        frame frame2;
        ModuleMethod moduleMethod2;
        ModuleMethod moduleMethod3;
        ModuleMethod moduleMethod4;
        ModuleMethod moduleMethod5;
        ModuleMethod moduleMethod6;
        ModuleMethod moduleMethod7;
        ModuleMethod moduleMethod8;
        ModuleMethod moduleMethod9;
        ModuleMethod moduleMethod10;
        ModuleMethod moduleMethod11;
        ModuleMethod moduleMethod12;
        ModuleMethod moduleMethod13;
        ModuleMethod moduleMethod14;
        ModuleMethod moduleMethod15;
        ModuleMethod moduleMethod16;
        ModuleMethod moduleMethod17;
        ModuleMethod moduleMethod18;
        ModuleMethod moduleMethod19;
        ModuleMethod moduleMethod20;
        ModuleMethod moduleMethod21;
        ModuleMethod moduleMethod22;
        ModuleMethod moduleMethod23;
        ModuleMethod moduleMethod24;
        ModuleMethod moduleMethod25;
        ModuleMethod moduleMethod26;
        ModuleMethod moduleMethod27;
        ModuleMethod moduleMethod28;
        ModuleMethod moduleMethod29;
        ModuleMethod moduleMethod30;
        ModuleMethod moduleMethod31;
        ModuleMethod moduleMethod32;
        ModuleMethod moduleMethod33;
        ModuleMethod moduleMethod34;
        ModuleMethod moduleMethod35;
        ModuleMethod moduleMethod36;
        ModuleMethod moduleMethod37;
        ModuleMethod moduleMethod38;
        ModuleMethod moduleMethod39;
        ModuleMethod moduleMethod40;
        ModuleMethod moduleMethod41;
        ModuleMethod moduleMethod42;
        ModuleMethod moduleMethod43;
        ModuleMethod moduleMethod44;
        ModuleMethod moduleMethod45;
        ModuleMethod moduleMethod46;
        ModuleMethod moduleMethod47;
        ModuleMethod moduleMethod48;
        ModuleMethod moduleMethod49;
        ModuleMethod moduleMethod50;
        ModuleMethod moduleMethod51;
        ModuleMethod moduleMethod52;
        ModuleMethod moduleMethod53;
        ModuleMethod moduleMethod54;
        ModuleMethod moduleMethod55;
        ModuleMethod moduleMethod56;
        ModuleMethod moduleMethod57;
        ModuleMethod moduleMethod58;
        ModuleMethod moduleMethod59;
        ModuleMethod moduleMethod60;
        ModuleMethod moduleMethod61;
        ModuleMethod moduleMethod62;
        ModuleMethod moduleMethod63;
        ModuleMethod moduleMethod64;
        ModuleMethod moduleMethod65;
        ModuleMethod moduleMethod66;
        ModuleMethod moduleMethod67;
        ModuleMethod moduleMethod68;
        ModuleMethod moduleMethod69;
        ModuleMethod moduleMethod70;
        ModuleMethod moduleMethod71;
        ModuleMethod moduleMethod72;
        ModuleInfo.register(this);
        ModuleMethod moduleMethod73 = moduleMethod;
        new frame();
        frame frame3 = frame2;
        frame3.$main = this;
        frame frame4 = frame3;
        new ModuleMethod(frame4, 1, Lit210, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.get$Mnsimple$Mnname = moduleMethod73;
        new ModuleMethod(frame4, 2, Lit211, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = moduleMethod2;
        new ModuleMethod(frame4, 3, Lit212, 8194);
        this.add$Mnto$Mnform$Mnenvironment = moduleMethod3;
        new ModuleMethod(frame4, 4, Lit213, 8193);
        this.lookup$Mnin$Mnform$Mnenvironment = moduleMethod4;
        new ModuleMethod(frame4, 6, Lit214, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = moduleMethod5;
        new ModuleMethod(frame4, 7, Lit215, 8194);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = moduleMethod6;
        new ModuleMethod(frame4, 8, Lit216, 8194);
        this.add$Mnto$Mnevents = moduleMethod7;
        new ModuleMethod(frame4, 9, Lit217, 16388);
        this.add$Mnto$Mncomponents = moduleMethod8;
        new ModuleMethod(frame4, 10, Lit218, 8194);
        this.add$Mnto$Mnglobal$Mnvars = moduleMethod9;
        new ModuleMethod(frame4, 11, Lit219, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = moduleMethod10;
        new ModuleMethod(frame4, 12, Lit220, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = moduleMethod11;
        new ModuleMethod(frame4, 13, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = moduleMethod12;
        new ModuleMethod(frame4, 14, Lit221, 16388);
        this.dispatchEvent = moduleMethod13;
        new ModuleMethod(frame4, 15, Lit222, 16388);
        this.dispatchGenericEvent = moduleMethod14;
        new ModuleMethod(frame4, 16, Lit223, 8194);
        this.lookup$Mnhandler = moduleMethod15;
        new ModuleMethod(frame4, 17, (Object) null, 0);
        ModuleMethod moduleMethod74 = moduleMethod16;
        moduleMethod74.setProperty("source-location", "/tmp/runtime7437719223159864720.scm:615");
        lambda$Fn1 = moduleMethod74;
        new ModuleMethod(frame4, 18, "$define", 0);
        this.$define = moduleMethod17;
        new ModuleMethod(frame4, 19, (Object) null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn3 = moduleMethod18;
        new ModuleMethod(frame4, 20, (Object) null, 0);
        lambda$Fn2 = moduleMethod19;
        new ModuleMethod(frame4, 21, (Object) null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn6 = moduleMethod20;
        new ModuleMethod(frame4, 22, (Object) null, 0);
        lambda$Fn5 = moduleMethod21;
        new ModuleMethod(frame4, 23, (Object) null, 0);
        lambda$Fn4 = moduleMethod22;
        new ModuleMethod(frame4, 24, (Object) null, 0);
        lambda$Fn7 = moduleMethod23;
        new ModuleMethod(frame4, 25, (Object) null, 0);
        lambda$Fn9 = moduleMethod24;
        new ModuleMethod(frame4, 26, (Object) null, 0);
        lambda$Fn8 = moduleMethod25;
        new ModuleMethod(frame4, 27, (Object) null, 8194);
        lambda$Fn10 = moduleMethod26;
        new ModuleMethod(frame4, 28, (Object) null, 8194);
        lambda$Fn12 = moduleMethod27;
        new ModuleMethod(frame4, 29, (Object) null, 0);
        lambda$Fn11 = moduleMethod28;
        new ModuleMethod(frame4, 30, (Object) null, 16388);
        lambda$Fn13 = moduleMethod29;
        new ModuleMethod(frame4, 31, (Object) null, 16388);
        lambda$Fn15 = moduleMethod30;
        new ModuleMethod(frame4, 32, (Object) null, 0);
        lambda$Fn14 = moduleMethod31;
        new ModuleMethod(frame4, 33, (Object) null, 0);
        lambda$Fn16 = moduleMethod32;
        new ModuleMethod(frame4, 34, Lit96, 0);
        this.indoot$Initialize = moduleMethod33;
        new ModuleMethod(frame4, 35, (Object) null, 0);
        lambda$Fn17 = moduleMethod34;
        new ModuleMethod(frame4, 36, (Object) null, 0);
        lambda$Fn18 = moduleMethod35;
        new ModuleMethod(frame4, 37, (Object) null, 0);
        lambda$Fn19 = moduleMethod36;
        new ModuleMethod(frame4, 38, (Object) null, 0);
        lambda$Fn20 = moduleMethod37;
        new ModuleMethod(frame4, 39, (Object) null, 0);
        lambda$Fn21 = moduleMethod38;
        new ModuleMethod(frame4, 40, (Object) null, 0);
        lambda$Fn22 = moduleMethod39;
        new ModuleMethod(frame4, 41, (Object) null, 0);
        lambda$Fn23 = moduleMethod40;
        new ModuleMethod(frame4, 42, (Object) null, 0);
        lambda$Fn24 = moduleMethod41;
        new ModuleMethod(frame4, 43, (Object) null, 0);
        lambda$Fn25 = moduleMethod42;
        new ModuleMethod(frame4, 44, (Object) null, 0);
        lambda$Fn26 = moduleMethod43;
        new ModuleMethod(frame4, 45, (Object) null, 0);
        lambda$Fn27 = moduleMethod44;
        new ModuleMethod(frame4, 46, (Object) null, 0);
        lambda$Fn28 = moduleMethod45;
        new ModuleMethod(frame4, 47, (Object) null, 0);
        lambda$Fn29 = moduleMethod46;
        new ModuleMethod(frame4, 48, (Object) null, 0);
        lambda$Fn30 = moduleMethod47;
        new ModuleMethod(frame4, 49, (Object) null, 0);
        lambda$Fn31 = moduleMethod48;
        new ModuleMethod(frame4, 50, (Object) null, 0);
        lambda$Fn32 = moduleMethod49;
        new ModuleMethod(frame4, 51, (Object) null, 0);
        lambda$Fn33 = moduleMethod50;
        new ModuleMethod(frame4, 52, (Object) null, 0);
        lambda$Fn34 = moduleMethod51;
        new ModuleMethod(frame4, 53, (Object) null, 0);
        lambda$Fn35 = moduleMethod52;
        new ModuleMethod(frame4, 54, (Object) null, 0);
        lambda$Fn36 = moduleMethod53;
        new ModuleMethod(frame4, 55, (Object) null, 0);
        lambda$Fn37 = moduleMethod54;
        new ModuleMethod(frame4, 56, (Object) null, 0);
        lambda$Fn38 = moduleMethod55;
        new ModuleMethod(frame4, 57, (Object) null, 0);
        lambda$Fn39 = moduleMethod56;
        new ModuleMethod(frame4, 58, (Object) null, 0);
        lambda$Fn40 = moduleMethod57;
        new ModuleMethod(frame4, 59, (Object) null, 0);
        lambda$Fn41 = moduleMethod58;
        new ModuleMethod(frame4, 60, (Object) null, 0);
        lambda$Fn42 = moduleMethod59;
        new ModuleMethod(frame4, 61, (Object) null, 0);
        lambda$Fn43 = moduleMethod60;
        new ModuleMethod(frame4, 62, (Object) null, 0);
        lambda$Fn44 = moduleMethod61;
        new ModuleMethod(frame4, 63, (Object) null, 0);
        lambda$Fn45 = moduleMethod62;
        new ModuleMethod(frame4, 64, (Object) null, 0);
        lambda$Fn46 = moduleMethod63;
        new ModuleMethod(frame4, 65, (Object) null, 0);
        lambda$Fn47 = moduleMethod64;
        new ModuleMethod(frame4, 66, (Object) null, 0);
        lambda$Fn48 = moduleMethod65;
        new ModuleMethod(frame4, 67, (Object) null, 0);
        lambda$Fn49 = moduleMethod66;
        new ModuleMethod(frame4, 68, (Object) null, 0);
        lambda$Fn50 = moduleMethod67;
        new ModuleMethod(frame4, 69, (Object) null, 0);
        lambda$Fn51 = moduleMethod68;
        new ModuleMethod(frame4, 70, (Object) null, 0);
        lambda$Fn52 = moduleMethod69;
        new ModuleMethod(frame4, 71, (Object) null, 0);
        lambda$Fn53 = moduleMethod70;
        new ModuleMethod(frame4, 72, (Object) null, 0);
        lambda$Fn54 = moduleMethod71;
        new ModuleMethod(frame4, 73, Lit206, 12291);
        this.Orientation_Sensor1$OrientationChanged = moduleMethod72;
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        Throwable th;
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Object obj2;
        Consumer $result = $ctx.consumer;
        runtime.$instance.run();
        this.$Stdebug$Mnform$St = Boolean.FALSE;
        this.form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
        Object[] objArr = new Object[2];
        objArr[0] = misc.symbol$To$String(Lit0);
        Object[] objArr2 = objArr;
        objArr2[1] = "-global-vars";
        FString stringAppend = strings.stringAppend(objArr2);
        FString fString = stringAppend;
        if (stringAppend == null) {
            obj = null;
        } else {
            obj = fString.toString();
        }
        this.global$Mnvar$Mnenvironment = Environment.make(obj);
        indoot = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, lambda$Fn2), $result);
        } else {
            addToGlobalVars(Lit3, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit41, lambda$Fn7), $result);
        } else {
            addToGlobalVars(Lit41, lambda$Fn8);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit27, lambda$Fn10), $result);
        } else {
            addToGlobalVars(Lit27, lambda$Fn11);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit59, lambda$Fn13), $result);
        } else {
            addToGlobalVars(Lit59, lambda$Fn14);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit0, Lit76, Lit77, Lit8);
            Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit0, Lit78, "5573807689433088", Lit79);
            Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit0, Lit80, "SilentSonics", Lit79);
            Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit0, Lit81, Lit82, Lit8);
            Object andCoerceProperty$Ex5 = runtime.setAndCoerceProperty$Ex(Lit0, Lit83, Lit84, Lit8);
            Object andCoerceProperty$Ex6 = runtime.setAndCoerceProperty$Ex(Lit0, Lit85, Lit86, Lit8);
            Object andCoerceProperty$Ex7 = runtime.setAndCoerceProperty$Ex(Lit0, Lit87, AlgorithmIdentifiers.NONE, Lit79);
            Object andCoerceProperty$Ex8 = runtime.setAndCoerceProperty$Ex(Lit0, Lit88, Boolean.FALSE, Lit89);
            Object andCoerceProperty$Ex9 = runtime.setAndCoerceProperty$Ex(Lit0, Lit90, "AppTheme.Light.DarkActionBar", Lit79);
            Object andCoerceProperty$Ex10 = runtime.setAndCoerceProperty$Ex(Lit0, Lit91, "indoot", Lit79);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit92, Boolean.FALSE, Lit89), $result);
        } else {
            new Promise(lambda$Fn16);
            addToFormDoAfterCreation(obj2);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Object addToCurrentFormEnvironment = runtime.addToCurrentFormEnvironment(Lit96, this.indoot$Initialize);
        } else {
            addToFormEnvironment(Lit96, this.indoot$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "indoot", "Initialize");
        } else {
            addToEvents(Lit0, Lit97);
        }
        this.Vertical_Arrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit98, Lit99, lambda$Fn17), $result);
        } else {
            addToComponents(Lit0, Lit102, Lit99, lambda$Fn18);
        }
        this.Card_View2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit99, Lit103, Lit104, lambda$Fn19), $result);
        } else {
            addToComponents(Lit99, Lit109, Lit104, lambda$Fn20);
        }
        this.Horizontal_Arrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit104, Lit110, Lit111, lambda$Fn21), $result);
        } else {
            addToComponents(Lit104, Lit112, Lit111, lambda$Fn22);
        }
        this.Card_View3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit111, Lit113, Lit114, lambda$Fn23), $result);
        } else {
            addToComponents(Lit111, Lit121, Lit114, lambda$Fn24);
        }
        this.Label2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit122, Lit123, lambda$Fn25), $result);
        } else {
            addToComponents(Lit114, Lit129, Lit123, lambda$Fn26);
        }
        this.Custom_Progress1_copy1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit130, Lit131, lambda$Fn27), $result);
        } else {
            addToComponents(Lit114, Lit132, Lit131, lambda$Fn28);
        }
        this.Custom_Progress1_copy2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit133, Lit134, lambda$Fn29), $result);
        } else {
            addToComponents(Lit114, Lit136, Lit134, lambda$Fn30);
        }
        this.Custom_Progress1_copy3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit137, Lit138, lambda$Fn31), $result);
        } else {
            addToComponents(Lit114, Lit139, Lit138, lambda$Fn32);
        }
        this.Custom_Progress1_copy = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit140, Lit141, lambda$Fn33), $result);
        } else {
            addToComponents(Lit114, Lit142, Lit141, lambda$Fn34);
        }
        this.Custom_Progress1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit114, Lit143, Lit144, lambda$Fn35), $result);
        } else {
            addToComponents(Lit114, Lit145, Lit144, lambda$Fn36);
        }
        this.Card_View4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit111, Lit146, Lit147, lambda$Fn37), $result);
        } else {
            addToComponents(Lit111, Lit149, Lit147, lambda$Fn38);
        }
        this.Vertical_Arrangement3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit147, Lit150, Lit151, lambda$Fn39), $result);
        } else {
            addToComponents(Lit147, Lit153, Lit151, lambda$Fn40);
        }
        this.Vertical_Arrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit151, Lit154, Lit155, lambda$Fn41), $result);
        } else {
            addToComponents(Lit151, Lit159, Lit155, lambda$Fn42);
        }
        this.Canvas1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit155, Lit160, Lit4, lambda$Fn43), $result);
        } else {
            addToComponents(Lit155, Lit162, Lit4, lambda$Fn44);
        }
        this.Label3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit151, Lit163, Lit164, lambda$Fn45), $result);
        } else {
            addToComponents(Lit151, Lit166, Lit164, lambda$Fn46);
        }
        this.Vertical_Arrangement4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit167, Lit168, lambda$Fn47), $result);
        } else {
            addToComponents(Lit0, Lit169, Lit168, lambda$Fn48);
        }
        this.Card_View1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit168, Lit170, Lit171, lambda$Fn49), $result);
        } else {
            addToComponents(Lit168, Lit172, Lit171, lambda$Fn50);
        }
        this.Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit171, Lit173, Lit174, lambda$Fn51), $result);
        } else {
            addToComponents(Lit171, Lit175, Lit174, lambda$Fn52);
        }
        this.Lottie1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit171, Lit176, Lit177, lambda$Fn53), $result);
        } else {
            addToComponents(Lit171, Lit179, Lit177, lambda$Fn54);
        }
        this.BluetoothLE1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit180, Lit181, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit182, Lit181, Boolean.FALSE);
        }
        this.Magnetic_Field_Sensor1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit183, Lit184, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit185, Lit184, Boolean.FALSE);
        }
        this.Accelerometer_Sensor1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit186, Lit187, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit188, Lit187, Boolean.FALSE);
        }
        this.KIO4_Move1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit189, Lit190, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit191, Lit190, Boolean.FALSE);
        }
        this.Orientation_Sensor1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit192, Lit193, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit194, Lit193, Boolean.FALSE);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Object addToCurrentFormEnvironment2 = runtime.addToCurrentFormEnvironment(Lit206, this.Orientation_Sensor1$OrientationChanged);
        } else {
            addToFormEnvironment(Lit206, this.Orientation_Sensor1$OrientationChanged);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Orientation_Sensor1", "OrientationChanged");
        } else {
            addToEvents(Lit193, Lit207);
        }
        this.Notifier1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit208, Lit93, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit209, Lit93, Boolean.FALSE);
        }
        runtime.initRuntime();
    }

    /* compiled from: indoot.yail */
    public class frame extends ModuleBody {
        indoot $main;

        public frame() {
        }

        public Object apply3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3) {
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj4 = obj;
            Object obj5 = obj2;
            Object obj6 = obj3;
            return moduleMethod2.selector == 73 ? this.$main.Orientation_Sensor1$OrientationChanged(obj4, obj5, obj6) : super.apply3(moduleMethod2, obj4, obj5, obj6);
        }

        public int match3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, CallContext callContext) {
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj4 = obj;
            Object obj5 = obj2;
            Object obj6 = obj3;
            CallContext callContext2 = callContext;
            if (moduleMethod2.selector != 73) {
                return super.match3(moduleMethod2, obj4, obj5, obj6, callContext2);
            }
            callContext2.value1 = obj4;
            callContext2.value2 = obj5;
            callContext2.value3 = obj6;
            callContext2.proc = moduleMethod2;
            callContext2.pc = 3;
            return 0;
        }

        public Object apply0(ModuleMethod moduleMethod) {
            ModuleMethod moduleMethod2 = moduleMethod;
            switch (moduleMethod2.selector) {
                case 17:
                    return indoot.lambda2();
                case 18:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return indoot.lambda3();
                case 22:
                    return indoot.lambda6();
                case 23:
                    return indoot.lambda5();
                case 24:
                    return indoot.lambda8();
                case 25:
                    return indoot.lambda10();
                case 26:
                    return indoot.lambda9();
                case 29:
                    return indoot.lambda12();
                case 32:
                    return indoot.lambda15();
                case 33:
                    return indoot.lambda17();
                case 34:
                    return this.$main.indoot$Initialize();
                case 35:
                    return indoot.lambda18();
                case 36:
                    return indoot.lambda19();
                case 37:
                    return indoot.lambda20();
                case 38:
                    return indoot.lambda21();
                case 39:
                    return indoot.lambda22();
                case 40:
                    return indoot.lambda23();
                case 41:
                    return indoot.lambda24();
                case 42:
                    return indoot.lambda25();
                case 43:
                    return indoot.lambda26();
                case 44:
                    return indoot.lambda27();
                case 45:
                    return indoot.lambda28();
                case 46:
                    return indoot.lambda29();
                case 47:
                    return indoot.lambda30();
                case 48:
                    return indoot.lambda31();
                case 49:
                    return indoot.lambda32();
                case 50:
                    return indoot.lambda33();
                case 51:
                    return indoot.lambda34();
                case 52:
                    return indoot.lambda35();
                case 53:
                    return indoot.lambda36();
                case 54:
                    return indoot.lambda37();
                case 55:
                    return indoot.lambda38();
                case 56:
                    return indoot.lambda39();
                case 57:
                    return indoot.lambda40();
                case 58:
                    return indoot.lambda41();
                case 59:
                    return indoot.lambda42();
                case 60:
                    return indoot.lambda43();
                case 61:
                    return indoot.lambda44();
                case 62:
                    return indoot.lambda45();
                case 63:
                    return indoot.lambda46();
                case 64:
                    return indoot.lambda47();
                case 65:
                    return indoot.lambda48();
                case 66:
                    return indoot.lambda49();
                case 67:
                    return indoot.lambda50();
                case 68:
                    return indoot.lambda51();
                case 69:
                    return indoot.lambda52();
                case 70:
                    return indoot.lambda53();
                case 71:
                    return indoot.lambda54();
                case 72:
                    return indoot.lambda55();
                default:
                    return super.apply0(moduleMethod2);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            Throwable th;
            Throwable th2;
            Throwable th3;
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj3 = obj;
            Object obj4 = obj2;
            switch (moduleMethod2.selector) {
                case 3:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj3, obj4);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        ClassCastException classCastException = e;
                        Throwable th4 = th3;
                        new WrongType(classCastException, "add-to-form-environment", 1, obj3);
                        throw th4;
                    }
                case 4:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj3, obj4);
                    } catch (ClassCastException e2) {
                        ClassCastException classCastException2 = e2;
                        Throwable th5 = th2;
                        new WrongType(classCastException2, "lookup-in-form-environment", 1, obj3);
                        throw th5;
                    }
                case 7:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj3, obj4);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        ClassCastException classCastException3 = e3;
                        Throwable th6 = th;
                        new WrongType(classCastException3, "add-to-global-var-environment", 1, obj3);
                        throw th6;
                    }
                case 8:
                    this.$main.addToEvents(obj3, obj4);
                    return Values.empty;
                case 10:
                    this.$main.addToGlobalVars(obj3, obj4);
                    return Values.empty;
                case 16:
                    return this.$main.lookupHandler(obj3, obj4);
                case 27:
                    return indoot.lambda11(obj3, obj4);
                case 28:
                    return indoot.lambda13(obj3, obj4);
                default:
                    return super.apply2(moduleMethod2, obj3, obj4);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            Throwable th;
            Throwable th2;
            Throwable th3;
            Throwable th4;
            Throwable th5;
            Throwable th6;
            Throwable th7;
            Throwable th8;
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj5 = obj;
            Object obj6 = obj2;
            Object obj7 = obj3;
            Object obj8 = obj4;
            switch (moduleMethod2.selector) {
                case 9:
                    this.$main.addToComponents(obj5, obj6, obj7, obj8);
                    return Values.empty;
                case 14:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj5, (String) obj6, (String) obj7, (Object[]) obj8) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    ClassCastException classCastException = e;
                                    Throwable th9 = th8;
                                    new WrongType(classCastException, "dispatchEvent", 4, obj8);
                                    throw th9;
                                }
                            } catch (ClassCastException e2) {
                                ClassCastException classCastException2 = e2;
                                Throwable th10 = th7;
                                new WrongType(classCastException2, "dispatchEvent", 3, obj7);
                                throw th10;
                            }
                        } catch (ClassCastException e3) {
                            ClassCastException classCastException3 = e3;
                            Throwable th11 = th6;
                            new WrongType(classCastException3, "dispatchEvent", 2, obj6);
                            throw th11;
                        }
                    } catch (ClassCastException e4) {
                        ClassCastException classCastException4 = e4;
                        Throwable th12 = th5;
                        new WrongType(classCastException4, "dispatchEvent", 1, obj5);
                        throw th12;
                    }
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    this.$main.dispatchGenericEvent((Component) obj5, (String) obj6, obj7 != Boolean.FALSE, (Object[]) obj8);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    ClassCastException classCastException5 = e5;
                                    Throwable th13 = th4;
                                    new WrongType(classCastException5, "dispatchGenericEvent", 4, obj8);
                                    throw th13;
                                }
                            } catch (ClassCastException e6) {
                                ClassCastException classCastException6 = e6;
                                Throwable th14 = th3;
                                new WrongType(classCastException6, "dispatchGenericEvent", 3, obj7);
                                throw th14;
                            }
                        } catch (ClassCastException e7) {
                            ClassCastException classCastException7 = e7;
                            Throwable th15 = th2;
                            new WrongType(classCastException7, "dispatchGenericEvent", 2, obj6);
                            throw th15;
                        }
                    } catch (ClassCastException e8) {
                        ClassCastException classCastException8 = e8;
                        Throwable th16 = th;
                        new WrongType(classCastException8, "dispatchGenericEvent", 1, obj5);
                        throw th16;
                    }
                case 30:
                    return indoot.lambda14(obj5, obj6, obj7, obj8);
                case 31:
                    return indoot.lambda16(obj5, obj6, obj7, obj8);
                default:
                    return super.apply4(moduleMethod2, obj5, obj6, obj7, obj8);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            ModuleMethod moduleMethod2 = moduleMethod;
            CallContext callContext2 = callContext;
            switch (moduleMethod2.selector) {
                case 17:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 18:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 20:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 22:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 23:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 24:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 25:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 26:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 29:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 32:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 33:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 34:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 35:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 36:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 37:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 38:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 39:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 40:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 41:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 42:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 43:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 44:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 45:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 46:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 47:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 48:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 49:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 50:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 51:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 52:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 53:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 54:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 55:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 56:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 57:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 58:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 59:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 60:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 61:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 62:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 63:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 64:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 65:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 66:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 67:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 68:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 69:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 70:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 71:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                case 72:
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod2, callContext2);
            }
        }

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj2 = obj;
            CallContext callContext2 = callContext;
            switch (moduleMethod2.selector) {
                case 1:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 2:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 4:
                    CallContext callContext3 = callContext2;
                    Object obj3 = obj2;
                    Object obj4 = obj3;
                    if (!(obj3 instanceof Symbol)) {
                        return -786431;
                    }
                    callContext3.value1 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 6:
                    CallContext callContext4 = callContext2;
                    Object obj5 = obj2;
                    Object obj6 = obj5;
                    if (!(obj5 instanceof Symbol)) {
                        return -786431;
                    }
                    callContext4.value1 = obj6;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 11:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 12:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 13:
                    CallContext callContext5 = callContext2;
                    Object obj7 = obj2;
                    Object obj8 = obj7;
                    if (!(obj7 instanceof indoot)) {
                        return -786431;
                    }
                    callContext5.value1 = obj8;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 19:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                case 21:
                    callContext2.value1 = obj2;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod2, obj2, callContext2);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj3 = obj;
            Object obj4 = obj2;
            CallContext callContext2 = callContext;
            switch (moduleMethod2.selector) {
                case 3:
                    CallContext callContext3 = callContext2;
                    Object obj5 = obj3;
                    Object obj6 = obj5;
                    if (!(obj5 instanceof Symbol)) {
                        return -786431;
                    }
                    callContext3.value1 = obj6;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 4:
                    CallContext callContext4 = callContext2;
                    Object obj7 = obj3;
                    Object obj8 = obj7;
                    if (!(obj7 instanceof Symbol)) {
                        return -786431;
                    }
                    callContext4.value1 = obj8;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 7:
                    CallContext callContext5 = callContext2;
                    Object obj9 = obj3;
                    Object obj10 = obj9;
                    if (!(obj9 instanceof Symbol)) {
                        return -786431;
                    }
                    callContext5.value1 = obj10;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 8:
                    callContext2.value1 = obj3;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 10:
                    callContext2.value1 = obj3;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 16:
                    callContext2.value1 = obj3;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 27:
                    callContext2.value1 = obj3;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                case 28:
                    callContext2.value1 = obj3;
                    callContext2.value2 = obj4;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod2, obj3, obj4, callContext2);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj5 = obj;
            Object obj6 = obj2;
            Object obj7 = obj3;
            Object obj8 = obj4;
            CallContext callContext2 = callContext;
            switch (moduleMethod2.selector) {
                case 9:
                    callContext2.value1 = obj5;
                    callContext2.value2 = obj6;
                    callContext2.value3 = obj7;
                    callContext2.value4 = obj8;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 4;
                    return 0;
                case 14:
                    CallContext callContext3 = callContext2;
                    Object obj9 = obj5;
                    Object obj10 = obj9;
                    if (!(obj9 instanceof indoot)) {
                        return -786431;
                    }
                    callContext3.value1 = obj10;
                    CallContext callContext4 = callContext2;
                    Object obj11 = obj6;
                    Object obj12 = obj11;
                    if (!(obj11 instanceof Component)) {
                        return -786430;
                    }
                    callContext4.value2 = obj12;
                    CallContext callContext5 = callContext2;
                    Object obj13 = obj7;
                    Object obj14 = obj13;
                    if (!(obj13 instanceof String)) {
                        return -786429;
                    }
                    callContext5.value3 = obj14;
                    CallContext callContext6 = callContext2;
                    Object obj15 = obj8;
                    Object obj16 = obj15;
                    if (!(obj15 instanceof String)) {
                        return -786428;
                    }
                    callContext6.value4 = obj16;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 4;
                    return 0;
                case 15:
                    CallContext callContext7 = callContext2;
                    Object obj17 = obj5;
                    Object obj18 = obj17;
                    if (!(obj17 instanceof indoot)) {
                        return -786431;
                    }
                    callContext7.value1 = obj18;
                    CallContext callContext8 = callContext2;
                    Object obj19 = obj6;
                    Object obj20 = obj19;
                    if (!(obj19 instanceof Component)) {
                        return -786430;
                    }
                    callContext8.value2 = obj20;
                    CallContext callContext9 = callContext2;
                    Object obj21 = obj7;
                    Object obj22 = obj21;
                    if (!(obj21 instanceof String)) {
                        return -786429;
                    }
                    callContext9.value3 = obj22;
                    CallContext callContext10 = callContext2;
                    Object obj23 = obj8;
                    Object obj24 = obj23;
                    Object obj25 = obj23;
                    if (1 == 0) {
                        return -786428;
                    }
                    callContext10.value4 = obj24;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 4;
                    return 0;
                case 30:
                    callContext2.value1 = obj5;
                    callContext2.value2 = obj6;
                    callContext2.value3 = obj7;
                    callContext2.value4 = obj8;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 4;
                    return 0;
                case 31:
                    callContext2.value1 = obj5;
                    callContext2.value2 = obj6;
                    callContext2.value3 = obj7;
                    callContext2.value4 = obj8;
                    callContext2.proc = moduleMethod2;
                    callContext2.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod2, obj5, obj6, obj7, obj8, callContext2);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            Throwable th;
            Throwable th2;
            ModuleMethod moduleMethod2 = moduleMethod;
            Object obj2 = obj;
            switch (moduleMethod2.selector) {
                case 1:
                    return this.$main.getSimpleName(obj2);
                case 2:
                    this.$main.androidLogForm(obj2);
                    return Values.empty;
                case 4:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj2);
                    } catch (ClassCastException e) {
                        ClassCastException classCastException = e;
                        Throwable th3 = th2;
                        new WrongType(classCastException, "lookup-in-form-environment", 1, obj2);
                        throw th3;
                    }
                case 6:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e2) {
                        ClassCastException classCastException2 = e2;
                        Throwable th4 = th;
                        new WrongType(classCastException2, "is-bound-in-form-environment", 1, obj2);
                        throw th4;
                    }
                case 11:
                    this.$main.addToFormDoAfterCreation(obj2);
                    return Values.empty;
                case 12:
                    this.$main.sendError(obj2);
                    return Values.empty;
                case 13:
                    this.$main.processException(obj2);
                    return Values.empty;
                case 19:
                    return indoot.lambda4(obj2);
                case 21:
                    return indoot.lambda7(obj2);
                default:
                    return super.apply1(moduleMethod2, obj2);
            }
        }
    }

    static Object lambda3() {
        Object callComponentMethod = runtime.callComponentMethod(Lit4, Lit5, LList.Empty, LList.Empty);
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit6, Lit7, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit10, Lit8);
        Object yailForRange = runtime.yailForRange(lambda$Fn3, Lit17, runtime.callYailPrimitive(AddOp.$Pl, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit20, Marker.ANY_NON_NULL_MARKER), Lit21);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit17, Lit8);
        Object callComponentMethod2 = runtime.callComponentMethod(Lit4, Lit22, LList.list4(runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit24, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit25, "yail-divide"), Lit21, Boolean.TRUE), Lit26);
        Object apply3 = Scheme.applyToArgs.apply3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit27, runtime.$Stthe$Mnnull$Mnvalue$St), Lit28, Lit28);
        return runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit28, Lit28, runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit29, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit30, "yail-divide")), Lit31);
    }

    static Object lambda4(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object $number = obj;
        SimpleSymbol simpleSymbol = Lit4;
        SimpleSymbol simpleSymbol2 = Lit11;
        IntNum intNum = Lit12;
        if ($number instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj2 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj2 = $number;
        }
        IntNum intNum2 = Lit14;
        if ($number instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj3 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj3 = $number;
        }
        Object callComponentMethod = runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list4(intNum, obj2, intNum2, obj3), Lit15);
        SimpleSymbol simpleSymbol3 = Lit4;
        SimpleSymbol simpleSymbol4 = Lit11;
        if ($number instanceof Package) {
            Object[] objArr7 = new Object[3];
            objArr7[0] = "The variable ";
            Object[] objArr8 = objArr7;
            objArr8[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr9 = objArr8;
            objArr9[2] = " is not bound in the current context";
            obj4 = runtime.signalRuntimeError(strings.stringAppend(objArr9), "Unbound Variable");
        } else {
            obj4 = $number;
        }
        IntNum intNum3 = Lit12;
        if ($number instanceof Package) {
            Object[] objArr10 = new Object[3];
            objArr10[0] = "The variable ";
            Object[] objArr11 = objArr10;
            objArr11[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr12 = objArr11;
            objArr12[2] = " is not bound in the current context";
            obj5 = runtime.signalRuntimeError(strings.stringAppend(objArr12), "Unbound Variable");
        } else {
            obj5 = $number;
        }
        return runtime.callComponentMethod(simpleSymbol3, simpleSymbol4, LList.list4(obj4, intNum3, obj5, Lit14), Lit16);
    }

    static Procedure lambda5() {
        return lambda$Fn5;
    }

    static Object lambda6() {
        Object callComponentMethod = runtime.callComponentMethod(Lit4, Lit5, LList.Empty, LList.Empty);
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit6, Lit7, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit10, Lit8);
        Object yailForRange = runtime.yailForRange(lambda$Fn6, Lit17, runtime.callYailPrimitive(AddOp.$Pl, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit34, Marker.ANY_NON_NULL_MARKER), Lit21);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit17, Lit8);
        Object callComponentMethod2 = runtime.callComponentMethod(Lit4, Lit22, LList.list4(runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit35, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit36, "yail-divide"), Lit21, Boolean.TRUE), Lit37);
        Object apply3 = Scheme.applyToArgs.apply3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit27, runtime.$Stthe$Mnnull$Mnvalue$St), Lit28, Lit28);
        return runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit28, Lit28, runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit38, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit39, "yail-divide")), Lit40);
    }

    static Object lambda7(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object $number = obj;
        SimpleSymbol simpleSymbol = Lit4;
        SimpleSymbol simpleSymbol2 = Lit11;
        IntNum intNum = Lit12;
        if ($number instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj2 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj2 = $number;
        }
        IntNum intNum2 = Lit14;
        if ($number instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj3 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj3 = $number;
        }
        Object callComponentMethod = runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list4(intNum, obj2, intNum2, obj3), Lit32);
        SimpleSymbol simpleSymbol3 = Lit4;
        SimpleSymbol simpleSymbol4 = Lit11;
        if ($number instanceof Package) {
            Object[] objArr7 = new Object[3];
            objArr7[0] = "The variable ";
            Object[] objArr8 = objArr7;
            objArr8[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr9 = objArr8;
            objArr9[2] = " is not bound in the current context";
            obj4 = runtime.signalRuntimeError(strings.stringAppend(objArr9), "Unbound Variable");
        } else {
            obj4 = $number;
        }
        IntNum intNum3 = Lit12;
        if ($number instanceof Package) {
            Object[] objArr10 = new Object[3];
            objArr10[0] = "The variable ";
            Object[] objArr11 = objArr10;
            objArr11[1] = runtime.getDisplayRepresentation(Lit13);
            Object[] objArr12 = objArr11;
            objArr12[2] = " is not bound in the current context";
            obj5 = runtime.signalRuntimeError(strings.stringAppend(objArr12), "Unbound Variable");
        } else {
            obj5 = $number;
        }
        return runtime.callComponentMethod(simpleSymbol3, simpleSymbol4, LList.list4(obj4, intNum3, obj5, Lit14), Lit33);
    }

    static Object lambda10() {
        Object apply3 = Scheme.applyToArgs.apply3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit27, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42, Lit43);
        Object callComponentMethod = runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit28, Lit28, Lit42, Lit43), Lit48);
        return runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit42, Lit43, runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit49, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit50, "yail-divide")), Lit51);
    }

    static Object lambda8() {
        Object apply3 = Scheme.applyToArgs.apply3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit27, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42, Lit43);
        Object callComponentMethod = runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit28, Lit28, Lit42, Lit43), Lit44);
        return runtime.callComponentMethod(Lit4, Lit11, LList.list4(Lit42, Lit43, runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit23), Lit19), Lit45, "yail-divide"), runtime.callYailPrimitive(runtime.yail$Mndivide, LList.list2(runtime.get$Mnproperty.apply2(Lit4, Lit18), Lit19), Lit46, "yail-divide")), Lit47);
    }

    static Procedure lambda9() {
        return lambda$Fn9;
    }

    static Object lambda11(Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Object $x = obj;
        Object $y = obj2;
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit6, Lit52, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit17, Lit8);
        SimpleSymbol simpleSymbol = Lit4;
        SimpleSymbol simpleSymbol2 = Lit22;
        if ($x instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit53);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj3 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj3 = $x;
        }
        if ($y instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit54);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj4 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj4 = $y;
        }
        Object callComponentMethod = runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list4(obj3, obj4, Lit55, Boolean.TRUE), Lit56);
        return runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit57, Lit8);
    }

    static Procedure lambda12() {
        return lambda$Fn12;
    }

    static Object lambda13(Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Object $x = obj;
        Object $y = obj2;
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit6, Lit52, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit17, Lit8);
        SimpleSymbol simpleSymbol = Lit4;
        SimpleSymbol simpleSymbol2 = Lit22;
        if ($x instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit53);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj3 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj3 = $x;
        }
        if ($y instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit54);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj4 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj4 = $y;
        }
        Object callComponentMethod = runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list4(obj3, obj4, Lit55, Boolean.TRUE), Lit58);
        return runtime.setAndCoerceProperty$Ex(Lit4, Lit9, Lit57, Lit8);
    }

    static Object lambda14(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object $x1 = obj;
        Object $x2 = obj2;
        Object $y1 = obj3;
        Object $y2 = obj4;
        GenericProc genericProc = numbers.sqrt;
        AddOp addOp = AddOp.$Pl;
        expt expt = expt.expt;
        AddOp addOp2 = AddOp.$Mn;
        if ($x1 instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit60);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj5 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj5 = $x1;
        }
        if ($x2 instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit61);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj6 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj6 = $x2;
        }
        Object callYailPrimitive = runtime.callYailPrimitive(expt, LList.list2(runtime.callYailPrimitive(addOp2, LList.list2(obj5, obj6), Lit62, "-"), Lit19), Lit63, "expt");
        expt expt2 = expt.expt;
        AddOp addOp3 = AddOp.$Mn;
        if ($y1 instanceof Package) {
            Object[] objArr7 = new Object[3];
            objArr7[0] = "The variable ";
            Object[] objArr8 = objArr7;
            objArr8[1] = runtime.getDisplayRepresentation(Lit64);
            Object[] objArr9 = objArr8;
            objArr9[2] = " is not bound in the current context";
            obj7 = runtime.signalRuntimeError(strings.stringAppend(objArr9), "Unbound Variable");
        } else {
            obj7 = $y1;
        }
        if ($y2 instanceof Package) {
            Object[] objArr10 = new Object[3];
            objArr10[0] = "The variable ";
            Object[] objArr11 = objArr10;
            objArr11[1] = runtime.getDisplayRepresentation(Lit65);
            Object[] objArr12 = objArr11;
            objArr12[2] = " is not bound in the current context";
            obj8 = runtime.signalRuntimeError(strings.stringAppend(objArr12), "Unbound Variable");
        } else {
            obj8 = $y2;
        }
        return runtime.callYailPrimitive(genericProc, LList.list1(runtime.callYailPrimitive(addOp, LList.list2(callYailPrimitive, runtime.callYailPrimitive(expt2, LList.list2(runtime.callYailPrimitive(addOp3, LList.list2(obj7, obj8), Lit66, "-"), Lit19), Lit67, "expt")), Lit68, Marker.ANY_NON_NULL_MARKER)), Lit69, "sqrt");
    }

    static Procedure lambda15() {
        return lambda$Fn15;
    }

    static Object lambda16(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object $x1 = obj;
        Object $x2 = obj2;
        Object $y1 = obj3;
        Object $y2 = obj4;
        GenericProc genericProc = numbers.sqrt;
        AddOp addOp = AddOp.$Pl;
        expt expt = expt.expt;
        AddOp addOp2 = AddOp.$Mn;
        if ($x1 instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit60);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj5 = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj5 = $x1;
        }
        if ($x2 instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit61);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj6 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj6 = $x2;
        }
        Object callYailPrimitive = runtime.callYailPrimitive(expt, LList.list2(runtime.callYailPrimitive(addOp2, LList.list2(obj5, obj6), Lit70, "-"), Lit19), Lit71, "expt");
        expt expt2 = expt.expt;
        AddOp addOp3 = AddOp.$Mn;
        if ($y1 instanceof Package) {
            Object[] objArr7 = new Object[3];
            objArr7[0] = "The variable ";
            Object[] objArr8 = objArr7;
            objArr8[1] = runtime.getDisplayRepresentation(Lit64);
            Object[] objArr9 = objArr8;
            objArr9[2] = " is not bound in the current context";
            obj7 = runtime.signalRuntimeError(strings.stringAppend(objArr9), "Unbound Variable");
        } else {
            obj7 = $y1;
        }
        if ($y2 instanceof Package) {
            Object[] objArr10 = new Object[3];
            objArr10[0] = "The variable ";
            Object[] objArr11 = objArr10;
            objArr11[1] = runtime.getDisplayRepresentation(Lit65);
            Object[] objArr12 = objArr11;
            objArr12[2] = " is not bound in the current context";
            obj8 = runtime.signalRuntimeError(strings.stringAppend(objArr12), "Unbound Variable");
        } else {
            obj8 = $y2;
        }
        return runtime.callYailPrimitive(genericProc, LList.list1(runtime.callYailPrimitive(addOp, LList.list2(callYailPrimitive, runtime.callYailPrimitive(expt2, LList.list2(runtime.callYailPrimitive(addOp3, LList.list2(obj7, obj8), Lit72, "-"), Lit19), Lit73, "expt")), Lit74, Marker.ANY_NON_NULL_MARKER)), Lit75, "sqrt");
    }

    static Object lambda17() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit0, Lit76, Lit77, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit0, Lit78, "5573807689433088", Lit79);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit0, Lit80, "SilentSonics", Lit79);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit0, Lit81, Lit82, Lit8);
        Object andCoerceProperty$Ex5 = runtime.setAndCoerceProperty$Ex(Lit0, Lit83, Lit84, Lit8);
        Object andCoerceProperty$Ex6 = runtime.setAndCoerceProperty$Ex(Lit0, Lit85, Lit86, Lit8);
        Object andCoerceProperty$Ex7 = runtime.setAndCoerceProperty$Ex(Lit0, Lit87, AlgorithmIdentifiers.NONE, Lit79);
        Object andCoerceProperty$Ex8 = runtime.setAndCoerceProperty$Ex(Lit0, Lit88, Boolean.FALSE, Lit89);
        Object andCoerceProperty$Ex9 = runtime.setAndCoerceProperty$Ex(Lit0, Lit90, "AppTheme.Light.DarkActionBar", Lit79);
        Object andCoerceProperty$Ex10 = runtime.setAndCoerceProperty$Ex(Lit0, Lit91, "indoot", Lit79);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit92, Boolean.FALSE, Lit89);
    }

    public Object indoot$Initialize() {
        runtime.setThisForm();
        Object apply1 = Scheme.applyToArgs.apply1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St));
        return runtime.callComponentMethod(Lit93, Lit94, LList.list3("We are using free tier servers as backend signaling server in this version ", "Server Resource Limited !", "Continue"), Lit95);
    }

    static Object lambda18() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit99, Lit18, Lit100, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit99, Lit23, Lit101, Lit8);
    }

    static Object lambda19() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit99, Lit18, Lit100, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit99, Lit23, Lit101, Lit8);
    }

    static Object lambda20() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit104, Lit81, Lit105, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit104, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit104, Lit108, Lit107, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit104, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit23, Lit101, Lit8);
    }

    static Object lambda21() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit104, Lit81, Lit105, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit104, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit104, Lit108, Lit107, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit104, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit23, Lit101, Lit8);
    }

    static Object lambda22() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit111, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit23, Lit101, Lit8);
    }

    static Object lambda23() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit111, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit23, Lit101, Lit8);
    }

    static Object lambda24() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit114, Lit81, Lit115, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit114, Lit116, Lit12, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit114, Lit117, Lit12, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit114, Lit118, Lit12, Lit8);
        Object andCoerceProperty$Ex5 = runtime.setAndCoerceProperty$Ex(Lit114, Lit119, Lit12, Lit8);
        Object andCoerceProperty$Ex6 = runtime.setAndCoerceProperty$Ex(Lit114, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex7 = runtime.setAndCoerceProperty$Ex(Lit114, Lit108, Lit55, Lit8);
        Object andCoerceProperty$Ex8 = runtime.setAndCoerceProperty$Ex(Lit114, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit114, Lit23, Lit120, Lit8);
    }

    static Object lambda25() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit114, Lit81, Lit115, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit114, Lit116, Lit12, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit114, Lit117, Lit12, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit114, Lit118, Lit12, Lit8);
        Object andCoerceProperty$Ex5 = runtime.setAndCoerceProperty$Ex(Lit114, Lit119, Lit12, Lit8);
        Object andCoerceProperty$Ex6 = runtime.setAndCoerceProperty$Ex(Lit114, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex7 = runtime.setAndCoerceProperty$Ex(Lit114, Lit108, Lit55, Lit8);
        Object andCoerceProperty$Ex8 = runtime.setAndCoerceProperty$Ex(Lit114, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit114, Lit23, Lit120, Lit8);
    }

    static Object lambda26() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit123, Lit81, Lit124, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit123, Lit125, "2", Lit79);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit123, Lit126, Lit17, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit123, Lit127, Lit128, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit123, Lit23, Lit101, Lit8);
    }

    static Object lambda27() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit123, Lit81, Lit124, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit123, Lit125, "2", Lit79);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit123, Lit126, Lit17, Lit8);
        Object andCoerceProperty$Ex4 = runtime.setAndCoerceProperty$Ex(Lit123, Lit127, Lit128, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit123, Lit23, Lit101, Lit8);
    }

    static Object lambda28() {
        return runtime.setAndCoerceProperty$Ex(Lit131, Lit18, Lit101, Lit8);
    }

    static Object lambda29() {
        return runtime.setAndCoerceProperty$Ex(Lit131, Lit18, Lit101, Lit8);
    }

    static Object lambda30() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit134, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda31() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit134, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda32() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit138, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit138, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda33() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit138, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit138, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda34() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit141, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda35() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit141, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit135, Boolean.FALSE, Lit89);
    }

    static Object lambda36() {
        return runtime.setAndCoerceProperty$Ex(Lit144, Lit18, Lit101, Lit8);
    }

    static Object lambda37() {
        return runtime.setAndCoerceProperty$Ex(Lit144, Lit18, Lit101, Lit8);
    }

    static Object lambda38() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit147, Lit81, Lit148, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit147, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit147, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit23, Lit101, Lit8);
    }

    static Object lambda39() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit147, Lit81, Lit148, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit147, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit147, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit23, Lit101, Lit8);
    }

    static Object lambda40() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit151, Lit81, Lit152, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit151, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit151, Lit23, Lit101, Lit8);
    }

    static Object lambda41() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit151, Lit81, Lit152, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit151, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit151, Lit23, Lit101, Lit8);
    }

    static Object lambda42() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit155, Lit156, Lit157, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit155, Lit158, Lit19, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit155, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit155, Lit23, Lit101, Lit8);
    }

    static Object lambda43() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit155, Lit156, Lit157, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit155, Lit158, Lit19, Lit8);
        Object andCoerceProperty$Ex3 = runtime.setAndCoerceProperty$Ex(Lit155, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit155, Lit23, Lit101, Lit8);
    }

    static Object lambda44() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit81, Lit161, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit4, Lit23, Lit101, Lit8);
    }

    static Object lambda45() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit4, Lit81, Lit161, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit4, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit4, Lit23, Lit101, Lit8);
    }

    static Object lambda46() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit164, Lit126, Lit17, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit164, Lit127, Lit165, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit164, Lit23, Lit101, Lit8);
    }

    static Object lambda47() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit164, Lit126, Lit17, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit164, Lit127, Lit165, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit164, Lit23, Lit101, Lit8);
    }

    static Object lambda48() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit168, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit168, Lit23, Lit101, Lit8);
    }

    static Object lambda49() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit168, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit168, Lit23, Lit101, Lit8);
    }

    static Object lambda50() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit171, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit171, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit171, Lit23, Lit101, Lit8);
    }

    static Object lambda51() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit171, Lit106, Lit107, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit171, Lit18, Lit101, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit171, Lit23, Lit101, Lit8);
    }

    static Object lambda52() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit174, Lit125, "Computing Local Cluster Map...", Lit79);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit174, Lit126, Lit17, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit174, Lit23, Lit101, Lit8);
    }

    static Object lambda53() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit174, Lit125, "Computing Local Cluster Map...", Lit79);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit174, Lit126, Lit17, Lit8);
        return runtime.setAndCoerceProperty$Ex(Lit174, Lit23, Lit101, Lit8);
    }

    static Object lambda54() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit177, Lit18, Lit101, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit177, Lit178, "61116-netsurf-radar-scan.json", Lit79);
        return runtime.setAndCoerceProperty$Ex(Lit177, Lit23, Lit101, Lit8);
    }

    static Object lambda55() {
        Object andCoerceProperty$Ex = runtime.setAndCoerceProperty$Ex(Lit177, Lit18, Lit101, Lit8);
        Object andCoerceProperty$Ex2 = runtime.setAndCoerceProperty$Ex(Lit177, Lit178, "61116-netsurf-radar-scan.json", Lit79);
        return runtime.setAndCoerceProperty$Ex(Lit177, Lit23, Lit101, Lit8);
    }

    public Object Orientation_Sensor1$OrientationChanged(Object $azimuth, Object $pitch, Object $roll) {
        Object obj;
        Object obj2;
        Object sanitizeComponentData = runtime.sanitizeComponentData($azimuth);
        Object sanitizeComponentData2 = runtime.sanitizeComponentData($pitch);
        Object sanitizeComponentData3 = runtime.sanitizeComponentData($roll);
        Object $azimuth2 = sanitizeComponentData;
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit190;
        SimpleSymbol simpleSymbol2 = Lit195;
        Object lookupInCurrentFormEnvironment = runtime.lookupInCurrentFormEnvironment(Lit155);
        MultiplyOp multiplyOp = MultiplyOp.$St;
        ModuleMethod moduleMethod = runtime.yail$Mnround;
        ModuleMethod moduleMethod2 = runtime.yail$Mndivide;
        if ($azimuth2 instanceof Package) {
            Object[] objArr = new Object[3];
            objArr[0] = "The variable ";
            Object[] objArr2 = objArr;
            objArr2[1] = runtime.getDisplayRepresentation(Lit196);
            Object[] objArr3 = objArr2;
            objArr3[2] = " is not bound in the current context";
            obj = runtime.signalRuntimeError(strings.stringAppend(objArr3), "Unbound Variable");
        } else {
            obj = $azimuth2;
        }
        Object callComponentMethod = runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list2(lookupInCurrentFormEnvironment, runtime.callYailPrimitive(multiplyOp, LList.list2(runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, LList.list2(obj, Lit197), Lit198, "yail-divide")), Lit199, "round"), Lit200), Lit201, Marker.ANY_MARKER)), Lit202);
        SimpleSymbol simpleSymbol3 = Lit164;
        SimpleSymbol simpleSymbol4 = Lit125;
        MultiplyOp multiplyOp2 = MultiplyOp.$St;
        ModuleMethod moduleMethod3 = runtime.yail$Mnround;
        ModuleMethod moduleMethod4 = runtime.yail$Mndivide;
        if ($azimuth2 instanceof Package) {
            Object[] objArr4 = new Object[3];
            objArr4[0] = "The variable ";
            Object[] objArr5 = objArr4;
            objArr5[1] = runtime.getDisplayRepresentation(Lit196);
            Object[] objArr6 = objArr5;
            objArr6[2] = " is not bound in the current context";
            obj2 = runtime.signalRuntimeError(strings.stringAppend(objArr6), "Unbound Variable");
        } else {
            obj2 = $azimuth2;
        }
        return runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol4, runtime.callYailPrimitive(multiplyOp2, LList.list2(runtime.callYailPrimitive(moduleMethod3, LList.list1(runtime.callYailPrimitive(moduleMethod4, LList.list2(obj2, Lit197), Lit203, "yail-divide")), Lit204, "round"), Lit197), Lit205, Marker.ANY_MARKER), Lit79);
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol symbol, Object obj) {
        Symbol name = symbol;
        Object object = obj;
        Object[] objArr = new Object[4];
        objArr[0] = "Adding ~A to env ~A with value ~A";
        Object[] objArr2 = objArr;
        objArr2[1] = name;
        Object[] objArr3 = objArr2;
        objArr3[2] = this.form$Mnenvironment;
        Object[] objArr4 = objArr3;
        objArr4[3] = object;
        androidLogForm(Format.formatToString(0, objArr4));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol symbol, Object obj) {
        Object obj2;
        Symbol name = symbol;
        Object default$Mnvalue = obj;
        boolean x = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & true;
        if (!x ? !x : !this.form$Mnenvironment.isBound(name)) {
            obj2 = default$Mnvalue;
        } else {
            obj2 = this.form$Mnenvironment.get(name);
        }
        return obj2;
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol symbol, Object obj) {
        Symbol name = symbol;
        Object object = obj;
        Object[] objArr = new Object[4];
        objArr[0] = "Adding ~A to env ~A with value ~A";
        Object[] objArr2 = objArr;
        objArr2[1] = name;
        Object[] objArr3 = objArr2;
        objArr3[2] = this.global$Mnvar$Mnenvironment;
        Object[] objArr4 = objArr3;
        objArr4[3] = object;
        androidLogForm(Format.formatToString(0, objArr4));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        Object obj = error;
        RetValManager.sendError(obj == null ? null : obj.toString());
    }

    public void processException(Object obj) {
        Object ex = obj;
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component component, String str, String str2, Object[] objArr) {
        boolean z;
        boolean z2;
        Component componentObject = component;
        String registeredComponentName = str;
        String eventName = str2;
        Object[] args = objArr;
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            z = false;
        } else if (lookupInFormEnvironment(registeredObject) == componentObject) {
            try {
                Object apply2 = Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                z2 = true;
            } catch (PermissionException e) {
                PermissionException exception = e;
                exception.printStackTrace();
                boolean x = this == componentObject;
                if (!x ? !x : !IsEqual.apply(eventName, "PermissionNeeded")) {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                } else {
                    processException(exception);
                }
                z2 = false;
            } catch (Throwable th) {
                Throwable exception2 = th;
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
                z2 = false;
            }
            z = z2;
        } else {
            z = false;
        }
        return z;
    }

    public void dispatchGenericEvent(Component component, String str, boolean z, Object[] objArr) {
        Boolean bool;
        Component componentObject = component;
        String eventName = str;
        boolean notAlreadyHandled = z;
        Object[] args = objArr;
        Object[] objArr2 = new Object[4];
        objArr2[0] = "any$";
        Object[] objArr3 = objArr2;
        objArr3[1] = getSimpleName(componentObject);
        Object[] objArr4 = objArr3;
        objArr4[2] = "$";
        Object[] objArr5 = objArr4;
        objArr5[3] = eventName;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend(objArr5)));
        if (handler != Boolean.FALSE) {
            try {
                Apply apply = Scheme.apply;
                Object obj = handler;
                Component component2 = componentObject;
                if (notAlreadyHandled) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                Object apply2 = apply.apply2(obj, lists.cons(component2, lists.cons(bool, LList.makeList(args, 0))));
            } catch (PermissionException e) {
                PermissionException exception = e;
                exception.printStackTrace();
                boolean x = this == componentObject;
                if (!x ? !x : !IsEqual.apply(eventName, "PermissionNeeded")) {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                } else {
                    processException(exception);
                }
            } catch (Throwable th) {
                Throwable exception2 = th;
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object obj) {
        Object eventName = obj;
        Object obj2 = componentName;
        String obj3 = obj2 == null ? null : obj2.toString();
        Object obj4 = eventName;
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj3, obj4 == null ? null : obj4.toString())));
    }

    public void $define() {
        Object obj;
        Throwable th;
        Object obj2;
        Throwable th2;
        Object obj3;
        Throwable th3;
        Object obj4;
        Throwable th4;
        Object obj5;
        Throwable th5;
        Object obj6;
        Throwable th6;
        Object obj7;
        Throwable th7;
        Object obj8;
        Throwable th8;
        Throwable th9;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception e) {
            Exception exception = e;
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        indoot = this;
        addToFormEnvironment(Lit0, this);
        Object obj9 = this.events$Mnto$Mnregister;
        while (true) {
            Object obj10 = obj9;
            if (obj10 == LList.Empty) {
                break;
            }
            Object obj11 = obj10;
            Object obj12 = obj11;
            try {
                Pair arg0 = (Pair) obj11;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj13 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj13, apply12 == null ? null : apply12.toString());
                obj9 = arg0.getCdr();
            } catch (ClassCastException e2) {
                ClassCastException classCastException = e2;
                Throwable th10 = th9;
                new WrongType(classCastException, "arg0", -2, obj12);
                throw th10;
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            LList event$Mninfo2 = components;
            while (event$Mninfo2 != LList.Empty) {
                Object obj14 = event$Mninfo2;
                obj6 = obj14;
                Pair arg02 = (Pair) obj14;
                Object component$Mninfo = arg02.getCar();
                Object apply13 = lists.caddr.apply1(component$Mninfo);
                Object apply14 = lists.cadddr.apply1(component$Mninfo);
                Object component$Mntype = lists.cadr.apply1(component$Mninfo);
                Object apply15 = lists.car.apply1(component$Mninfo);
                obj7 = apply15;
                Object component$Mnname = apply13;
                Object component$Mnobject = Invoke.make.apply2(component$Mntype, lookupInFormEnvironment((Symbol) apply15));
                Object apply3 = SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                Object obj15 = component$Mnname;
                obj8 = obj15;
                addToFormEnvironment((Symbol) obj15, component$Mnobject);
                event$Mninfo2 = arg02.getCdr();
            }
            LList reverse = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse != LList.Empty) {
                Object obj16 = reverse;
                obj4 = obj16;
                Pair arg03 = (Pair) obj16;
                Object var$Mnval = arg03.getCar();
                Object apply16 = lists.car.apply1(var$Mnval);
                obj5 = apply16;
                addToGlobalVarEnvironment((Symbol) apply16, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                reverse = arg03.getCdr();
            }
            Object reverse2 = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse2 != LList.Empty) {
                Object obj17 = reverse2;
                obj3 = obj17;
                Pair arg04 = (Pair) obj17;
                Object force = misc.force(arg04.getCar());
                reverse2 = arg04.getCdr();
            }
            LList component$Mndescriptors = components;
            LList lList = component$Mndescriptors;
            while (lList != LList.Empty) {
                Object obj18 = lList;
                obj2 = obj18;
                Pair arg05 = (Pair) obj18;
                Object component$Mninfo2 = arg05.getCar();
                Object apply17 = lists.caddr.apply1(component$Mninfo2);
                Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                if (init$Mnthunk != Boolean.FALSE) {
                    Object apply18 = Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                lList = arg05.getCdr();
            }
            LList lList2 = component$Mndescriptors;
            while (lList2 != LList.Empty) {
                Object obj19 = lList2;
                obj = obj19;
                Pair arg06 = (Pair) obj19;
                Object component$Mninfo3 = arg06.getCar();
                Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                Object apply19 = lists.cadddr.apply1(component$Mninfo3);
                callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                lList2 = arg06.getCdr();
            }
        } catch (ClassCastException e3) {
            ClassCastException classCastException2 = e3;
            Throwable th11 = th;
            new WrongType(classCastException2, "arg0", -2, obj);
            throw th11;
        } catch (ClassCastException e4) {
            ClassCastException classCastException3 = e4;
            Throwable th12 = th2;
            new WrongType(classCastException3, "arg0", -2, obj2);
            throw th12;
        } catch (ClassCastException e5) {
            ClassCastException classCastException4 = e5;
            Throwable th13 = th3;
            new WrongType(classCastException4, "arg0", -2, obj3);
            throw th13;
        } catch (ClassCastException e6) {
            ClassCastException classCastException5 = e6;
            Throwable th14 = th5;
            new WrongType(classCastException5, "add-to-global-var-environment", 0, obj5);
            throw th14;
        } catch (ClassCastException e7) {
            ClassCastException classCastException6 = e7;
            Throwable th15 = th4;
            new WrongType(classCastException6, "arg0", -2, obj4);
            throw th15;
        } catch (ClassCastException e8) {
            ClassCastException classCastException7 = e8;
            Throwable th16 = th8;
            new WrongType(classCastException7, "add-to-form-environment", 0, obj8);
            throw th16;
        } catch (ClassCastException e9) {
            ClassCastException classCastException8 = e9;
            Throwable th17 = th7;
            new WrongType(classCastException8, "lookup-in-form-environment", 0, obj7);
            throw th17;
        } catch (ClassCastException e10) {
            ClassCastException classCastException9 = e10;
            Throwable th18 = th6;
            new WrongType(classCastException9, "arg0", -2, obj6);
            throw th18;
        } catch (YailRuntimeError e11) {
            processException(e11);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        LList symbols = LList.makeList(argsArray, 0);
        LList lList = symbols;
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = symbols;
        Object obj2 = LList.Empty;
        while (true) {
            Object obj3 = obj2;
            Object obj4 = obj;
            if (obj4 == LList.Empty) {
                Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj3));
                Object obj5 = apply2;
                try {
                    return misc.string$To$Symbol((CharSequence) apply2);
                } catch (ClassCastException e) {
                    ClassCastException classCastException = e;
                    Throwable th4 = th;
                    new WrongType(classCastException, "string->symbol", 1, obj5);
                    throw th4;
                }
            } else {
                Object obj6 = obj4;
                Object obj7 = obj6;
                try {
                    Pair arg0 = (Pair) obj6;
                    obj = arg0.getCdr();
                    Object car = arg0.getCar();
                    Object obj8 = car;
                    try {
                        obj2 = Pair.make(misc.symbol$To$String((Symbol) car), obj3);
                    } catch (ClassCastException e2) {
                        ClassCastException classCastException2 = e2;
                        Throwable th5 = th3;
                        new WrongType(classCastException2, "symbol->string", 1, obj8);
                        throw th5;
                    }
                } catch (ClassCastException e3) {
                    ClassCastException classCastException3 = e3;
                    Throwable th6 = th2;
                    new WrongType(classCastException3, "arg0", -2, obj7);
                    throw th6;
                }
            }
        }
    }

    static Object lambda2() {
        return null;
    }
}
