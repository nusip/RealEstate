package kz.maks.realestate.front.ui.kvartira;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.core.front.ui.TextField;
import kz.maks.core.front.validation.AbstractFieldValidator;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.columns.KvartiraSaleHistoryColumn;
import kz.maks.realestate.front.columns.KvartiraSalePhoneColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.refs.IstochnikInfo;
import kz.maks.realestate.shared.refs.Valyuta;
import kz.maks.realestate.shared.refs.kvartira.*;

import javax.swing.*;

import java.awt.*;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static kz.maks.core.front.FrontUtils.setForcedWidth;
import static kz.maks.core.shared.Utils.DATE_FORMAT_FULL;
import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.realestate.front.UserUtils.connected;
import static kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField.*;

public class KvartiraSaleForm extends AbstractForm<KvartiraSaleDto> {
    private static final int COL_1_1_WIDTH = 360;
    private static final int COL_1_2_WIDTH = 270;

    private static final int COL_3_1_WIDTH = 300;
    private static final int COL_3_2_WIDTH = 330;

    private static final int COL_GAP_SIZE = 10;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int SHORT_FIELD_WIDTH = 50;

    private static final int LABEL_WIDTH_2 = 70;
    private static final int LABEL_WIDTH_3 = 120;

    public final JTabbedPane tabs = new JTabbedPane();
    public final JScrollPane historyPanel = new JScrollPane();
    public final Table<KvartiraSaleDto> table = new Table<>(KvartiraSaleHistoryColumn.values());

    public KvartiraSaleForm(Frame containerFrame) {
        super(containerFrame, KvartiraSaleFormField.values());
        tabs.setBorder(BorderFactory.createEmptyBorder());
        tabs.addTab("Квартира", buildForm());
        tabs.addTab("История изменений", buildHistoryPanel());
        ui.add(tabs);
        processAnnotations();
    }

    private Component buildHistoryPanel() {
        table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        historyPanel.setViewportView(table.ui);
        historyPanel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        return historyPanel;
    }

    private Component buildForm() {
        JPanel formPanel = new JPanel();
        FrontUtils.addMargins(formPanel);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        {
            fieldValues.put(id, new HiddenField(id));
            fieldValues.put(modifiedById, new HiddenField(modifiedById) {
                @Override
                public Object get() {
                    return extractId(connected());
                }
            });
        }
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addKolichestvoKomnat_etazh(vBox);
                addPloshad(vBox);
                addGodPostroiki_tipStroyeniya(vBox);
                addVZaloge(vBox);
                addCena(vBox);
                addCenaProdazhi(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRegion(vBox, parent);
                addUlica(vBox);
                addPeresechenie(vBox);
                addDomKvaritra(vBox);
                addTelNumbers(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        formPanel.add(FrontUtils.vGap(10));
        formPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        formPanel.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addOpisanie(vBox);
                addPrimechanie(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addSostoyanie(vBox);
                addPlanirovka(vBox);
                addTelefon(vBox);
                addSanuzel(vBox);
                addBalkon(vBox);
                addDver(vBox);
                addPol(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_1_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        formPanel.add(FrontUtils.vGap(10));
        formPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        formPanel.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addVArhive(vBox);
                addDataSozdaniya(vBox);
                addDataIzmeneniya(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_3_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRealtor(vBox);
                addIstochnikInformacii(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_3_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        return formPanel;
    }

    private void addVZaloge(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(isZalog.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            CheckBox checkBox = new CheckBox(KvartiraSaleFormField.isZalog);
            fieldValues.put(KvartiraSaleFormField.isZalog, checkBox);
            fieldRow.add(checkBox.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addGodPostroiki_tipStroyeniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(godPostroyki.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(godPostroyki);
            FrontUtils.setMinWidth(spinner.ui, SHORT_FIELD_WIDTH);
            FrontUtils.setPreferredWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldRow.add(spinner.ui);
            fieldValues.put(godPostroyki, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(tipStroyeniya.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.tipStroyeniya, TipStroyeniya.values());
            fieldValues.put(KvartiraSaleFormField.tipStroyeniya, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRealtor(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(assignedToId);
            setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
            
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(assignedToId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataIzmeneniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(updatedAt);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.updatedAt, DATE_FORMAT_FULL);
            fieldValues.put(KvartiraSaleFormField.updatedAt, dateSpinner);
            fieldComponents.put(updatedAt, dateSpinner.ui);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataSozdaniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(createdAt);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.createdAt, DATE_FORMAT_FULL);
            fieldValues.put(KvartiraSaleFormField.createdAt, dateSpinner);
            fieldComponents.put(createdAt, dateSpinner.ui);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addVArhive(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(isArchive);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);

            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(isArchive));
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPlanirovka(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(planirovka);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);

            fieldRow.add(FrontUtils.hGap());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(planirovka));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelNumbers2(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(telNumbers.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextFieldList textFieldList = new TextFieldList(telNumbers);
            fieldValues.put(telNumbers, textFieldList);
            fieldRow.add(textFieldList.ui);
        }
//        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelNumbers(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            final TableField<KvartiraSalePhoneRecord> numbers = new TableField<>(telNumbers, KvartiraSalePhoneColumn.values());
            fieldValues.put(telNumbers, new AbstractFieldValidator<List<String>>(telNumbers) {
                @Override
                public List<String> get() {
                    return newArrayList(
                            filter(
                                    transform(
                                            numbers.get(),
                                            new Function<KvartiraSalePhoneRecord, String>() {
                                                @Override
                                                public String apply(KvartiraSalePhoneRecord kvartiraSalePhoneRecord) {
                                                    return kvartiraSalePhoneRecord.getNumber();
                                                }
                                            }
                                    ),
                                    new Predicate<String>() {
                                        @Override
                                        public boolean apply(String s) {
                                            return !Strings.isNullOrEmpty(s);
                                        }
                                    }
                            ));
                }

                @Override
                public void set(List<String> val) {
                    numbers.set(val != null ? newArrayList(transform(val, new Function<String, KvartiraSalePhoneRecord>() {
                        @Override
                        public KvartiraSalePhoneRecord apply(String s) {
                            return new KvartiraSalePhoneRecord(s);
                        }
                    })) : null);
                }
            });
            fieldRow.add(numbers.ui);
        }
//        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPol(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(pol.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.pol, Pol.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.pol, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDver(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(dver.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.dver, Dver.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.dver, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addBalkon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(balkon.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.balkon, Balkon.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.balkon, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSanuzel(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(sanuzel.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.sanuzel, Sanuzel.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.sanuzel, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelefon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(telefon.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.telefon, Telefon.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.telefon, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPrimechanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.primechanie.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.primechanie);
            fieldValues.put(KvartiraSaleFormField.primechanie, textField);
            fieldRow.add(textField.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addIstochnikInformacii(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.istochnikInfo.title());
            setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.istochnikInfo, IstochnikInfo.values());
            fieldValues.put(KvartiraSaleFormField.istochnikInfo, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSostoyanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.sostoyaniye.title());
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.sostoyaniye, Sostoyaniye.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.sostoyaniye, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addOpisanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.raznoe.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextAreaField textAreaField = new TextAreaField(KvartiraSaleFormField.raznoe);
            JScrollPane scrollPane = new JScrollPane(textAreaField.ui);
            FrontUtils.setPreferredHeight(scrollPane, 100);
            FrontUtils.setMinHeight(scrollPane, 100);
            fieldValues.put(KvartiraSaleFormField.raznoe, textAreaField);
            fieldRow.add(scrollPane);
        }
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDomKvaritra(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.dom.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.dom);
            setForcedWidth(textField.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.dom, textField);
            fieldRow.add(textField.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.kvartira.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.kvartira);
            setForcedWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.kvartira, spinner);
            fieldRow.add(spinner.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());

        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCenaProdazhi(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.cenaProdazhi.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.cenaProdazhi, Spinner.DECIMAL_MODE);
            FrontUtils.setPreferredWidth(spinner.ui, 100);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleFormField.cenaProdazhi, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCena(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(cena));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(cena);
            FrontUtils.setPreferredWidth(component, 100);
            fieldRow.add(component);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(valyuta));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.valyuta, Valyuta.values());
            setForcedWidth(comboBox.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.valyuta, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPeresechenie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(peresechenie));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(peresechenie));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addUlica(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(ulica));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(ulica));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRegion(Box vBox, Frame parent) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(regionId));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(regionId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshad(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(ploshadObshaya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadObshaya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(ploshadZhilaya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadZhilaya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(ploshadKuhnya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadKuhnya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addKolichestvoKomnat_etazh(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(kolichestvoKomnat));
            fieldRow.add(FrontUtils.hGap());
            JComponent kolichestvoKomnat = addField(KvartiraSaleFormField.kolichestvoKomnat);
            setForcedWidth(kolichestvoKomnat, SHORT_FIELD_WIDTH);
            fieldRow.add(kolichestvoKomnat);
            fieldRow.add(FrontUtils.hGap());

            fieldRow.add(getLabel(etazh));
            fieldRow.add(FrontUtils.hGap());
            JComponent etazh = addField(KvartiraSaleFormField.etazh);
            setForcedWidth(etazh, SHORT_FIELD_WIDTH);
            fieldRow.add(etazh);
            fieldRow.add(FrontUtils.hGap());

            fieldRow.add(getLabel(etazhnost));
            fieldRow.add(FrontUtils.hGap());
            JComponent etazhnost = addField(KvartiraSaleFormField.etazhnost);
            setForcedWidth(etazhnost, SHORT_FIELD_WIDTH);
            fieldRow.add(etazhnost);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    public void setFieldHeight(Box fieldRow) {
        FrontUtils.setHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setPreferredHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setMaxHeight(fieldRow, FIELD_ROW_HEIGHT);
    }

    public void addFieldRowGap(Box fieldRow) {
        fieldRow.add(FrontUtils.vGap());
    }
}
